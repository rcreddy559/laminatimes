package com.laminatimes.apigatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class GatewayConfig {

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {

		System.out.println("--------GatewayConfigs----------------------");


		return builder.routes()
				.route(r -> r.path("/leaves/**").uri("http://localhost:8086").id("leaves-service"))
				.route(r -> r.path("/authenticate/**").uri("http://localhost:8085").id("admin-service"))
				.route(r -> r.path("/user/**").uri("http://localhost:8085").id("admin-service"))
				.build();
	}
}

