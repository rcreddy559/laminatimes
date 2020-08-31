package com.lamina.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
		return service.getTimesheet(id);
	}
}
