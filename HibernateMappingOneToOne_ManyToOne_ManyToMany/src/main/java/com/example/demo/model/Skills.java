package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Skills {
	@Id
	private int lid;
	
	private String language;
	
	@JsonBackReference
	@ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="skills")
	
	List<EmployeeDetails> employeeDetails =new ArrayList<>() ;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<EmployeeDetails> getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(List<EmployeeDetails> employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	@Override
	public String toString() {
		return "Skills [lid=" + lid + ", language=" + language + ", employeeDetails=" + employeeDetails + "]";
	}
	
	

}
