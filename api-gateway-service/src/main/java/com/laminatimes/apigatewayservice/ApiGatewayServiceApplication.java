package com.laminatimes.apigatewayservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

import reactor.core.publisher.Mono;

@EnableConfigurationProperties(UriConfiguration.class)
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
				.route(r -> r.path("/leave/**").uri("http://LEAVES-SERVICE"))
				.route(r -> r.path("/leave1/**").uri("http://leaves-service"))
				.route(r -> r.path("/user/**").uri("http://USER-SERVICE"))
				.route(r -> r.path("/user1/**").uri("http://user-service"))
				.route(r -> r.path("/holiday/**").uri("http://HOLIDAYS-SERVICE"))
				.route(r -> r.path("/holiday1/**").uri("http://holidays-service"))
				.build();
	}
	
	@Bean
	  public RouteLocator myRoutes(RouteLocatorBuilder builder, UriConfiguration uriConfiguration) {
	    String httpUri = uriConfiguration.getHttpbin();
	    return builder.routes()
	      .route(p -> p
	        .path("/get")
	        .filters(f -> f.addRequestHeader("Hello", "World"))
	        .uri(httpUri))
	      .route(p -> p
	        .host("*.hystrix.com")
	        .filters(f -> f
	          .hystrix(config -> config
	            .setName("mycmd")
	            .setFallbackUri("forward:/fallback")))
	        .uri(httpUri))
	      .build();
	  }

	  @RequestMapping("/fallback")
	  public Mono<String> fallback() {
	    return Mono.just("fallback");
	  }

}
