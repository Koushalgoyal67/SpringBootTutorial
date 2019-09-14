package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="Gender")
public class Gender {

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
	@SequenceGenerator(name="employee_generator", sequenceName ="oneToOne", allocationSize=5)
	@Column(name="genderId",nullable = false)
	int genderId;
	
	@Column(name="gender",length=1) //columnDefinition = "varchar(1) default 'M'"
	@ColumnDefault(value="'M'")
	private String gender="M"; 
	 
	//child table 
	//@JsonBackReference// for biDirectional mapping recurion of data error ,this column will not be seen in api json (do not get serialized)
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empId") //dont need to specify  referencedColumnName = "id" // as it take primary key of that table automatically
	private Employee employee;

	
	
	public Gender() {
	
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Gender setEmployee(Employee employee) {
		this.employee = employee;
		return this;
	}

	@Override
	public String toString() {
		return "Gender [genderId=" + genderId + ", gender=" + gender + ", employee=" + employee + "]";
	}

	


	
	
}
