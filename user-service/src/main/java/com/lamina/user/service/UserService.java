package com.lamina.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.lamina.user.controller.*;
import com.lamina.user.exception.UserException;
import com.lamina.user.response.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepository userRepository;

	private static UserResponse dtoToVo(User user) {
		UserResponse userResponse = new UserResponse();
		BeanUtils.copyProperties(user, userResponse);
		return userResponse;
	}

	public List<UserResponse> getUsers() {
		List<User> userDtos = userRepository.findAll();
		return userDtos.stream().map(UserService::dtoToVo).collect(Collectors.toList());
	}
	public UserResponse get(String userName) throws UserException {
		Optional<User> userDtoOptional = userRepository.findByUserName(userName);
		if(userDtoOptional.isPresent()) {
			UserResponse userResponse = new UserResponse();
			BeanUtils.copyProperties(userDtoOptional.get(), userResponse);
			return userResponse;
		} else  {
			throw new UserException("User not found with userName: " + userName);
		}
	}
	public UserResponse get(int id) throws UserException {
		Optional<User> userDtoOptional = userRepository.findById(id);
		if(userDtoOptional.isPresent()) {
			UserResponse userResponse = new UserResponse();
			BeanUtils.copyProperties(userDtoOptional.get(), userResponse);
			return userResponse;
		} else  {
			throw new UserException("User not found with id: " + id);
		}
	}

	public UserResponse save(final UserResponse userResponse) {
		logger.info("UserResponse Service ---------->>>>>>>>");

		User user = new User();
		BeanUtils.copyProperties(user, userResponse);
		final User u = userRepository.save(user);
		return dtoToVo(u);
	}

    public UserResponse update(UserResponse userResponse) {
		User user = new User();
		BeanUtils.copyProperties(user, userResponse);
		return dtoToVo(userRepository.save(user));
    }

    public void delete(int id) {
		try {
			userRepository.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new UserException("UserResponse not found!");
		}
	}
}
