package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentMongoRepo;
import com.example.demo.model.StudentMongo;

@RestController
@RequestMapping("/mongo")
public class StudentMongoController {

	@Autowired
	private StudentMongoRepo student1Repo;
	
	@GetMapping("/get/all")
	public List<StudentMongo> getStudent() {
		return student1Repo.findAll();
	}
	
	@GetMapping("/get/store")
	public void storeStudentData() {
		for(int i=0;i<20000;i++) {
			StudentMongo studentMongo =new StudentMongo();
			studentMongo.setId(i);
			studentMongo.setName("Koushal"+i);
			student1Repo.save(studentMongo);
		}
	}
}
