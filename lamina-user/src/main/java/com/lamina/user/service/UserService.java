package com.lamina.user.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.lamina.user.controller.*;
import com.lamina.user.exception.HolidayException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserService {
	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepository repository;

	@Autowired
	RestTemplate restTemplate;

	@Value("${url.leave}")
	String leaveUrl;

	@Value("${url.holiday}")
	String holidayUrl;

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

	public UserTimesheet getTimesheet(int id) {
		User user = get(id);
		logger.info(user.toString());

		List<Leave> leaves = getLeaves();
		List<Holiday> holidays = getHolidays();

		logger.info("Leaves size: {}", leaves.size());
		logger.info("Holiday size: {}", holidays.size());

		return new UserTimesheet(user, leaves, holidays);
	}

	@HystrixCommand(fallbackMethod = "getLeaves_fallback")
	private List<Leave> getLeaves() {
		ResponseEntity<List<Leave>> leaveEntity = restTemplate.exchange(
				leaveUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Leave>>(){});

		return leaveEntity.getBody();
	}

	private List getLeaves_fallback() {
		return Collections.EMPTY_LIST;
	}

	@HystrixCommand(fallbackMethod = "getHolidays_fallback")
	private List<Holiday> getHolidays() {
//		return WebClient.create().get().uri(holidayUrl).retrieve()
//				.toEntityList(Holiday.class).block().getBody();

		ResponseEntity<List<Holiday>> leaveEntity = restTemplate.exchange(
				holidayUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Holiday>>(){});
		return leaveEntity.getBody();
	}

	private List getHolidays_fallback() {
		return Collections.EMPTY_LIST;
	}

}
