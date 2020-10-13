package com.laminatimes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.laminatimes.util.JwtUtil;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages={"com.laminatimes"} )
public class AuthService 
{

	public static void main(String[] args) {
		SpringApplication.run(AuthService.class, args);
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
