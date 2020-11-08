package com.lamina.user.controller;

import com.lamina.user.exception.UserException;
import com.lamina.user.http.HttpUserService;
import com.lamina.user.http.JsonBodyHandler;
import com.lamina.user.response.Holiday;
import com.lamina.user.response.Leave;
import com.lamina.user.response.StockResponse;
import com.lamina.user.response.UserResponse;
import com.lamina.user.util.UserUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.lamina.user.service.UserService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	Logger logger= LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService service;
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	HttpUserService httpUserService;

	@Value("${url.leave}")
	String leaveUrl;

	@Value("${url.holiday}")
	String holidayUrl;
//
//	@Autowired
//	private KafkaSender sender;

	@PostMapping("/login")
	public UserResponse login(@RequestBody UserResponse userResponse) {
		final UserResponse response = service.get(userResponse.getUserName());

		if(UserUtil.matchesPassword(userResponse.getPassword(), response.getPassword())) {
			return response;
		} else {
			throw new UserException("User credentials not match, enter correct user name and password!");
		}
	}


	@GetMapping
	public List<UserResponse> getUsers() {
		logger.info(" get all users");
		return service.getUsers();
	}

	@GetMapping("/id/{id}")
	public UserResponse get(@PathVariable int id) {
		logger.info("Get User id:{}", id);
		return service.get(id);
	}

	@GetMapping("/id/{id}/stock")
	@HystrixCommand(fallbackMethod = "getStockFallBack")
	public List<StockResponse> getStock(@PathVariable int id) throws IOException, InterruptedException {
		logger.info("Get StockResponse for User id:{}", id);
		return httpUserService.getAllStock(id);
	}

	public List<StockResponse> getStockFallBack(int id) {
		logger.info("Get getStockFallBack for User id:{}", id);
		return List.of();
	}

	@GetMapping("/username/{userName}")
	public UserResponse getByUserName(@PathVariable String userName) {
		logger.info("Get User id:{}", userName);
		return service.get(userName);
	}
	
	@PostMapping
	public UserResponse save(@RequestBody UserResponse user) {
		logger.info("Create user: {}", user.toString());
		return service.save(user);
	}

	@PutMapping
	public UserResponse update(@RequestBody UserResponse user) {
		logger.info("Update user: {}", user.toString() );
		return service.update(user);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id){
		logger.debug("Delete user id:{}", id);
		service.delete(id);
	}


	@GetMapping("/timesheet/{id}")
	//@HystrixCommand(fallbackMethod = "getTimesheetFallBack")
	public UserTimesheet getTimesheet(@PathVariable int id) {
		logger.info("Get time sheet for user id: {}", id);
		
		logger.info("Rest template : Leave URL: {}", leaveUrl);
		logger.info("Rest template : Holiday URL: {}", holidayUrl);

		List<Leave> leaves = restTemplate.getForObject("http://LEAVES-SERVICE/leave", List.class);
		List<Holiday> holidays = restTemplate.getForObject("http://HOLIDAYS-SERVICE/holidays", List.class);

		return new UserTimesheet(service.get(id), leaves, holidays);
	}
	
	public UserTimesheet getTimesheetFallBack(@PathVariable int id) {
		logger.error("---------------getTimesheetFallBack---------------------");
		return new UserTimesheet();
	}

}
