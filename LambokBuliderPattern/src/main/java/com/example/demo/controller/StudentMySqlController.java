package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentMySqlRepo;
import com.example.demo.model.StudentMySql;

@RestController
@RequestMapping("/mysql")
public class StudentMySqlController {

	@Autowired
	private StudentMySqlRepo studentMySqlRepo;
	
	
	@GetMapping("/get/all")
	public List<StudentMySql> getAll() {
		return studentMySqlRepo.findAll();
	}
	
	@GetMapping("/get/store")
	public void storeStudentData() {
		for(int i=0; i<20;i++) {
			StudentMySql studentMySql = new StudentMySql();
			studentMySql.setId(i);
			studentMySql.setName("Koushal"+i);
			studentMySqlRepo.save(studentMySql);
		}
	}
	
	@GetMapping("/get/builder-pattern")
	public void storeStudentBuilderData() {
		for(int i=20; i<40;i++) {
			StudentMySql studentMySql =  StudentMySql.builder().id(i).name("Koushal"+i).build();
			studentMySqlRepo.save(studentMySql);
		}
	}
}
