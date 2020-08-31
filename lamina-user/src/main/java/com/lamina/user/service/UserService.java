package com.lamina.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.lamina.user.controller.*;
import com.lamina.user.exception.HolidayException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepository repository;

	private static User dtoToVo(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		return user;
	}

	public List<User> getUsers() {
		List<UserDto> userDtos = repository.findAll();
		return userDtos.stream().map(UserService::dtoToVo).collect(Collectors.toList());
	}

	public User get(int id) throws HolidayException {
		Optional<UserDto> userDtoOptional = repository.findById(id);
		if(userDtoOptional.isPresent()) {
			User user = new User();
			BeanUtils.copyProperties(userDtoOptional.get(), user);
			return user;
		} else  {
			throw new HolidayException("User not found!");
		}
	}

	public User save(User user) {
		logger.info("User Service ---------->>>>>>>>");
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return dtoToVo(repository.save(userDto));
	}

    public User update(User user) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return dtoToVo(repository.save(userDto));
    }

    public void delete(int id) {
		try {
			repository.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new HolidayException("User not found!");
		}
	}

	 


}
