package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyApi {
	
	@GetMapping("/get/api")
	public String get() {
		return "Hello Buddy";
	}
}
