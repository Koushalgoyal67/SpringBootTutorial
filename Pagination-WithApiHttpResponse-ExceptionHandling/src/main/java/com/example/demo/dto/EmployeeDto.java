package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Employee;

public class EmployeeDto {

	Iterable<Employee> data;

	public Iterable<Employee> getData() {
		return data;
	}

	public EmployeeDto setData(Iterable<Employee> data) {
		this.data = data;
		return this;
	}

	@Override
	public String toString() {
		return "EmployeeDto [data=" + data + "]";
	}
	
}
