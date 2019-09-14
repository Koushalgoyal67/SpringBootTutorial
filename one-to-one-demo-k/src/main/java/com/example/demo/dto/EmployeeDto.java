package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Employee;

public class EmployeeDto {

	String empName;
	int empId;
	String gender;
	int genderId;
	
	public int getEmpId() {
		return empId;
	}

	public EmployeeDto setEmpId(int empId) {
		this.empId = empId;
		return this;
	}

	public String getGender() {
		return gender;
	}

	public EmployeeDto setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public int getGenderId() {
		return genderId;
	}

	public EmployeeDto setGenderId(int genderId) {
		this.genderId = genderId;
		return this;
	}

	public String getEmpName() {
		return empName;
	}

	public EmployeeDto setEmpName(String empName) {
		this.empName = empName;
		return this;
	}

	@Override
	public String toString() {
		return "EmployeeDto [empName=" + empName + ", empId=" + empId + ", gender=" + gender + ", genderId=" + genderId
				+ "]";
	}

}
