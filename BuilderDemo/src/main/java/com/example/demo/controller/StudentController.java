package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentRepo;
import com.example.demo.model.Student;

@RestController
public class StudentController {

	volatile Student  student;
	@Autowired
	private StudentRepo studentRepo;
	
	@GetMapping("/get/all")
	public List<Student> getAll() {
		
		
		student= Student.Builder.newInstance() 
				               .setId(2) 
				               .setName("Shyam") 
				               .setAddress("Delhi") 
				               .build();
		studentRepo.save(student);

		return studentRepo.findAll();
	}
	

}
