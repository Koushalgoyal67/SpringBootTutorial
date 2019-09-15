package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Employee;

public class EmployeeDto {

	String token;
	List<Employee> data;
	public String getToken() {
		return token;
	}
	public EmployeeDto setToken(String token) {
		this.token = token;
		return this;
	}
	public List<Employee> getData() {
		return data;
	}
	public EmployeeDto setData(List<Employee> data) {
		this.data = data;
		return this;
	}
	@Override
	public String toString() {
		return "EmployeeDto [token=" + token + ", data=" + data + "]";
	}
	
	
}
