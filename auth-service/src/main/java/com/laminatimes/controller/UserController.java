package com.laminatimes.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.laminatimes.user.reg.UserRegRequest;
import com.laminatimes.service.UserRegistrationService;

@RestController("/")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRegistrationService userRegistrationService;
 
	@PostMapping(value = "user")
	public UserRegRequest save(@RequestBody UserRegRequest userProfile) {
		LOGGER.info("In registration controller save method ");
		userRegistrationService.save(userProfile);
		return userProfile;
	}
	
	@PutMapping(value = "user")
	public UserRegRequest update(@RequestBody UserRegRequest userProfile) {
		LOGGER.info("In registration controller update method ");
		System.out.println("User Profile: -->> "+userProfile.toString());
		userRegistrationService.save(userProfile);
		return userProfile;
	}
	
	@DeleteMapping(value = "user/{empNumber}")
	public boolean delete(@PathVariable("empNumber") String empNumber) {
		LOGGER.info("In registration controller Delete method ", empNumber);
		return userRegistrationService.delete(empNumber);
		
	}
	
	@GetMapping(value = "user")
	public List<UserRegRequest> getUsers() {
		LOGGER.info("In registration controller getUsers method ");
		List<UserRegRequest> users = userRegistrationService.getUsers();
		return users;
	}
	
	@GetMapping(value = "user/{empNumber}")
	public UserRegRequest getUserByEmpNo(@PathVariable("empNumber") String empNumber) {
		LOGGER.info("In registration controller getUserById method ", empNumber);
		UserRegRequest user = userRegistrationService.getUserByEmpNo(empNumber);
		return user;
	}
	
		 
}
