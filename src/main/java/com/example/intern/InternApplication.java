package com.example.intern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class InternApplication {

	public static void main(String[] args) {
		System.out.println("Starting...");
		SpringApplication.run(InternApplication.class, args);
	}

}
