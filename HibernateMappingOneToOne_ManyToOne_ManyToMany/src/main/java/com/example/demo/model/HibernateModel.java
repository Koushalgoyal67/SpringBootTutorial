package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HibernateModel {
	@Id
	@GeneratedValue
	private int EmployeeId;
	
	private String employeeName;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "HibernateModel [EmployeeId=" + EmployeeId + ", employeeName=" + employeeName + "]";
	}

}
