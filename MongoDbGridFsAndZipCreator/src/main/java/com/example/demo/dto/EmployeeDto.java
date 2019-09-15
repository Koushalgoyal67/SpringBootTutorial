package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Employee;

public class EmployeeDto {

	List <Employee> data ;

	public List<Employee> getData() {
		return data;
	}

	public EmployeeDto setData(List<Employee> data) {
		this.data = data;
		return this;
	}

	@Override
	public String toString() {
		return "EmployeeDto [data=" + data + "]";
	}
	
}
