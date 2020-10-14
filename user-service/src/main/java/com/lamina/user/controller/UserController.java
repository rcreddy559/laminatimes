package com.lamina.user.controller;

import com.lamina.user.config.KafkaSender;
import com.lamina.user.exception.UserException;
import com.lamina.user.response.Holiday;
import com.lamina.user.response.Leave;
import com.lamina.user.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.lamina.user.service.UserService;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/user")
public class UserController {
	Logger logger= LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService service;
	
	@Autowired
	RestTemplate restTemplate;

	@Value("${url.leave}")
	String leaveUrl;

	@Value("${url.holiday}")
	String holidayUrl;

	@Autowired
	private KafkaSender sender;

	@PostMapping("/login")
	public UserResponse login(@RequestBody UserResponse userResponse) {
		UserResponse response = service.get(userResponse.getUserName());

		if(validateLogin(userResponse, response)) {
			return response;
		} else {
			throw new UserException("User not found with username:"+ userResponse.getUserName());
		}
	}

	private boolean validateLogin(UserResponse userResponse, UserResponse response) {
		return UserUtil.matchesPassword(userResponse.getPassword(), response.getPassword());
	}

	@GetMapping
	public List<UserResponse> getUsers() {
		logger.info(" get all users");
		return service.getUsers();
	}

	@GetMapping("/{id}")
	public UserResponse get(@PathVariable int id) {
		logger.info("Get User id:{}", id);
		return service.get(id);
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

		List<Leave> leaves = restTemplate.getForObject("http://3.236.229.114:31468/leave", List.class);
		List<Holiday> holidays = restTemplate.getForObject("http://3.236.229.114:30643/holidays", List.class);

		return new UserTimesheet(service.get(id), leaves, holidays);
	}
	
	public UserTimesheet getTimesheetFallBack(@PathVariable int id) {
		logger.error("---------------getTimesheetFallBack---------------------");
		return new UserTimesheet();
	}

	 
}
