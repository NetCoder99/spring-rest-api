package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");		
		SpringApplication.run(WebApplication.class, args);
	}

}
