package com.laminatimes.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.laminatimes.admin.util.JwtUtil;

@ComponentScan(basePackages = "com.laminatimes")
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"com.laminatimes"} ,exclude = { HibernateJpaAutoConfiguration.class})
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}
	
	@Bean 
	public JwtUtil getJwtUtil() {
		return new JwtUtil();
	}

}
