package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

//	@Autowired
//	EmployeeRepo employeeRepo;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/get/all")
	public EmployeeDto getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	
	@PostMapping("/post/employee")
	public void postEmployee(@RequestBody EmployeeDto employeeDto) {
		 employeeService.postMultipleEmployee(employeeDto);
	}
}
