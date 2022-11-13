package com.example.springauthapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringAuthApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuthApiApplication.class, args);
	}

	@GetMapping("/test")
	public String test() {
		return "hello world again";
	}
}
