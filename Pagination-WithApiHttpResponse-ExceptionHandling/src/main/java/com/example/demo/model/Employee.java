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
@Table(name = "Employee" /*,catalog = "oneToOne"*/) //catalog is db name
public class Employee {

	@Id
	@Column(name = "empId", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
	@SequenceGenerator(name="employee_generator", sequenceName ="oneToOne", allocationSize=5) //sequence name is db name
	int id;
	
	@Column(name="name",length=50, nullable = false)  
	String name;



	public int getId() { 
		return id;
	}

	public Employee setId(int id) {
		this.id = id;
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
		return "Employee [empId=" + id + ", name=" + name + "]";
	}
	
	
}
