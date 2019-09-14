package com.example.demo.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee {

	@Id   //@Indexed(unique=true)
	int id;
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
