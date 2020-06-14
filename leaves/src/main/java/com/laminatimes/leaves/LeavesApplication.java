package com.laminatimes.leaves;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = "com.laminatimes")
@EnableAutoConfiguration
@EnableJpaRepositories("com.laminatimes.repository")
@SpringBootApplication(scanBasePackages={"com.laminatimes"} ,exclude = { HibernateJpaAutoConfiguration.class})
public class LeavesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeavesApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

}
