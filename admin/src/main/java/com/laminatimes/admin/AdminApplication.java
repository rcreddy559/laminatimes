package com.laminatimes.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.laminatimes.admin.util.JwtUtil;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages={"com.laminatimes"} )
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}
	
	@Bean 
	public JwtUtil getJwtUtil() {
		return new JwtUtil();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new LdapShaPasswordEncoder();
	}
}
