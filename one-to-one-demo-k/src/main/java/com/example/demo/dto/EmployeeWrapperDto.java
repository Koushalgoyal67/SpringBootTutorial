package com.example.demo.dto;

import java.util.List;

public class EmployeeWrapperDto {

	List<EmployeeDto> employeeDto;

	public List<EmployeeDto> getEmployeeDto() {
		return employeeDto;
	}

	public EmployeeWrapperDto setEmployeeDto(List<EmployeeDto> employeeDto) {
		this.employeeDto = employeeDto;
		return this;
	}


	
}
