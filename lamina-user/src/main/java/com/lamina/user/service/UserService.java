package com.lamina.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lamina.user.controller.User;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public List<User> getUsers() {
		
		return repository.findAll();
	}

	public Optional<User> get(Integer id) {
		return repository.findById(id);
	}

	public User save(User user) {
		return repository.save(user);
	}
	
	
}
