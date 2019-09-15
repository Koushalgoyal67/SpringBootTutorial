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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity(name="Employee")
@Table(name = "Employee" /*,catalog = "oneToOne"*/)
public class Employee {

	@Id
	@Column(name = "empId", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
	@SequenceGenerator(name="employee_generator", sequenceName ="oneToOne", allocationSize=5)
	int empId;
	
	@Column(name="name",length=50, nullable = false)  
	String name;
 
	//Parent table  as it contains mapped by
	// for bi-directional purpose
	//@JsonManagedReference //get Serialised in forward direction and will be seen in api json data
	@JsonBackReference
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	@JoinColumn(name="genderId")
    private Gender gender;
	

	public Gender getGender() {
		return gender;
	} 

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getEmpId() { 
		return empId;
	}

	public Employee setEmpId(int empId) {
		this.empId = empId;
		return this;
	}

	public String getName() {
		return name;
	}

	public Employee setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", gender=" + gender + "]";
	}
	
	
}
