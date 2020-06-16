package com.laminatimes.timesheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories("com.laminatimes.timesheet")
public class TimesheetApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimesheetApplication.class, args);
	}

	@Bean
	public RestTemplate createRestTemplate(){
		return  new RestTemplate();
	}
}
