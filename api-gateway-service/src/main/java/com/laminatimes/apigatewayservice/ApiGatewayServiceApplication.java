package com.laminatimes.apigatewayservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ApiGatewayServiceApplication {
	final static Logger logger= LoggerFactory.getLogger(ApiGatewayServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayServiceApplication.class, args);
	}

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		logger.info("gatewayRoutes() method");
		return builder.routes()
				.route(r -> r.path("/leave/**").uri("http://3.236.116.183:30616"))
				.route(r -> r.path("/user/**").uri("http://localhost:8084"))
				.route(r -> r.path("/holiday/**").uri("http://localhost:8088"))
				.build();
	}
}
