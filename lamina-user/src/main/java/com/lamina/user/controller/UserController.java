package com.lamina.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lamina.user.service.UserService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

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
	
	@GetMapping
	public List<User> getUsers() {
		logger.info(" get all users");
		return service.getUsers();
	}

	@GetMapping("/{id}")
	public User get(@PathVariable int id) {
		logger.info("Get User id:{}", id);
		return service.get(id);
	}
	
	@PostMapping
	public User save(@RequestBody User user) {
		logger.info("Create user: {}", user.toString());
		logger.info("Leave user url: {}", leaveUrl);
		logger.info("Holiday user url: {}", holidayUrl);
		return service.save(user);
	}

	@PutMapping
	public User update(@RequestBody User user) {
		logger.info("Update user: {}", user.toString() );
		return service.update(user);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id){
		logger.debug("Delete user id:{}", id);
		service.delete(id);
	}

	@GetMapping("/timesheet/{id}")
	public UserTimesheet getTimesheet(@PathVariable int id) {
		logger.info("Get time sheet for user id: {}", id);
		User user = get(id);
		logger.info(user.toString());

		ResponseEntity<List<Leave>> leaveEntity = restTemplate.exchange(
				leaveUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Leave>>(){});

		List<Leave> leaves = leaveEntity.getBody();
		logger.info("Leaves size: {}", leaves.size());

		List<Holiday> holidays = WebClient.create().get().uri(holidayUrl).retrieve()
									.toEntityList(Holiday.class).block().getBody();

		logger.info("Holiday size: {}", holidays.size());
		return new UserTimesheet(user, leaves, holidays);
	}
}
