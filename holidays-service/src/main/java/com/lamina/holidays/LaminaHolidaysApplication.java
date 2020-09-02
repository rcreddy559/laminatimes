package com.lamina.holidays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LaminaHolidaysApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaminaHolidaysApplication.class, args);
    }

}
