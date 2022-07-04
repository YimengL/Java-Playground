package com.optimagrowth.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
// Enable the service as a Spring Cloud Config Service
@EnableConfigServer
public class ConfigurationServerApplication {

	/**
	 * The {@link ConfigurationServerApplication#main(String[])} method launches the service and starts the Spring
	 * container.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigurationServerApplication.class, args);
	}

}
