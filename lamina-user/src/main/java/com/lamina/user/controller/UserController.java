package com.lamina.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lamina.user.service.UserService;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/user")
public class UserController {
	Logger logger= LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService service;
	
	@GetMapping()
	public List<User> getUsers() {
		logger.info(" get all users");
		
		return service.getUsers();
		
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable Integer id) {
		logger.info("get User");
		Optional<User> user = service.get(id);
		logger.info("User: {}", user.toString());
		return user.get();
	}
	
	@PostMapping()
	public User save(@RequestBody User user) {
		logger.info("Create user");
		User userResult = service.save(user);
		logger.info("Create User: {}", user.toString());
		return userResult;
	}
	
	@GetMapping("/timesheet")
	public UsetTimesheet getTimesheet(@PathVariable Integer id) {
		User user = getUser(id);
		
	}
}
