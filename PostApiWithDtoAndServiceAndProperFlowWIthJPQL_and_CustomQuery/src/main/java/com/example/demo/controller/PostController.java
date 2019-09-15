package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.dto.EmployeeColumnDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class PostController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@GetMapping("/get/{id}")
	public Employee getEmployee(@PathVariable("id") Integer id) {
		Optional<Employee> optional=employeeService.getEmployee(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	//JPQL
	@GetMapping("/get/employee/{id}")
	public EmployeeDto getEmployeeById(@PathVariable("id") Integer id) {
			return new EmployeeDto().setData(employeeService.getEmployeeByID(id)).setToken("Hello");
	}
	
	@GetMapping("/get/all")
	public EmployeeDto getEmployee() {
		return new EmployeeDto().setData(employeeService.getEmployee()).setToken("Shkjfdkjdsghfkjgdf");
	}
	
	//JPQL
	@GetMapping("/get/all/employee")
	public EmployeeDto getEmployeeCustomQuery() {
		//return employeeRepo.findAllEmployee();
		return new EmployeeDto().setData(employeeService.getAllEmployee()).setToken("Hello");
	}
	
	//JPQL for selected columns
	@GetMapping("/get/multiple/employee")
	public EmployeeColumnDto getMultipleEmployeeCustomQuery() {
		//return employeeRepo.findAllEmployee();
		//employeeService.getMultipleEmployee();
		return employeeService.getMultipleEmployee();
	}
	
	
	@PostMapping("/post/multiple")
	public void postMultipleEmployee(@RequestBody EmployeeDto employeeDto) {
		employeeService.postMultipleEmployee(employeeDto);
	}
}
