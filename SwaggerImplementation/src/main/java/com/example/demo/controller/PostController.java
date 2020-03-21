package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.service.EmployeeService;

@RestController
public class PostController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@GetMapping("/saveWithoutTransactional")
	public String saveWithoutTransactional() {
		employeeService.saveWithoutTransactional();
		return "saveWithoutTransactional";
	}
	
	@GetMapping("/saveWithTransactional")
	public String saveWithTransactional() {
		try {
			employeeService.saveWithTransactional();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "saveWithTransactional";
	}
	

}
