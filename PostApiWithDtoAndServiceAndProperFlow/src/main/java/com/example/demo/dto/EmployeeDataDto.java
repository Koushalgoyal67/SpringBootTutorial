package com.example.demo.dto;



public class EmployeeDataDto
{
	String firstName;
	String lastName;
	
	public EmployeeDataDto setFirstName(String firstName) {
		this.firstName=firstName;
		return this;
	}
	public EmployeeDataDto setLastName(String lastName) {
		this.lastName=lastName;
		return this;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
}
