package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
public class StudentController {
	
	@GetMapping("get/student/firstname")
	public String getStudentFirstname() {
		return new Student().getFirstName();
	}

	@GetMapping("get/student/lastname")
	public String getStudentLastName() {
		return new Student().getLastName();
	}
}
