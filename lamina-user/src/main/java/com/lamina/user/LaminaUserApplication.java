package com.lamina.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class LaminaUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaminaUserApplication.class, args);
	}

}
