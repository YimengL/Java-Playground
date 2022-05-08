package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


// Tells Spring Boot that this class is the entry point for the Spring Boot service
@SpringBootApplication
// Tells Spring Boot to expose the code in this class as a Spring RestController
@RestController
// Prefaces all URLs exposed in this application with a /hello prefix
@RequestMapping(value = "hello")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Maps the firstName and lastName parameters to the two parameters to the two variables passed into the hello
	 * function.
	 * @return	a simple JSON string that we manually build (in chapter 2, we won't create any JSON)
	 */
	@GetMapping(value = "/{firstName}")
	public String helloGet(@PathVariable("firstName") String firstName,
						   @RequestParam("lastName") String lastName) {
		return String.format("{\"message\":\"Hello %s %s\"}", firstName, lastName);
	}

	@PostMapping
	public String helloPost(@RequestBody HelloRequest request) {
		return String.format("{\"message\":\"Hello %s %s\"}", request.getFirstName(), request.getLastName());
	}
}

/**
 * Contains the fields of the JSON structure sent by the user
 */
class HelloRequest {
	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
