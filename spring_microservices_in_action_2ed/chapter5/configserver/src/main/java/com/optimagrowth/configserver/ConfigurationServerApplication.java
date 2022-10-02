package com.optimagrowth.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

// Our Config service is a Spring Boot application, so we must mark it with the @SpringBootApplication annotation
@SpringBootApplication
// Enables the service as a Spring Cloud Config service
@EnableConfigServer
public class ConfigurationServerApplication {

	/**
	 * The main method launches the service and starts the Spring container.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigurationServerApplication.class, args);
	}

}
