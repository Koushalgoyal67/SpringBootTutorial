package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentMongoRepo;
import com.example.demo.model.StudentMongo;
import com.example.demo.model.StudentMySql; 

@RestController
@RequestMapping("/mongo")
public class StudentMongoController {

	@Autowired
	private StudentMongoRepo studentMongoRepo;
	
	@GetMapping("/get/all")
	public List<StudentMongo> getStudent() {
		return studentMongoRepo.findAll();
	}
	
	@GetMapping("/get/store")
	public void storeStudentData() {
		for(int i=0;i<10;i++) {
			StudentMongo studentMongo =new StudentMongo();
			studentMongo.setId(i);
			studentMongo.setName("Koushal"+i);
			studentMongoRepo.save(studentMongo);
		}
	}
	
	@GetMapping("/get/builder-pattern")
	public void storeStudentBuilderData() {
		for(int i=10; i<20;i++) {
			StudentMongo studentMongo =  StudentMongo.builder().id(i).name("Koushal"+i).build();
			studentMongoRepo.save(studentMongo);
		}
	}
}

