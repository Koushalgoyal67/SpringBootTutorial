package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Entity(name="StudentMySql")
@Table(name="StudentMySql")
@Data
@Builder
public class StudentMySql {
	@Id
	private int id;
	
	@Column(name="name")
	String name; 
		
	@Tolerate
	public	StudentMySql(){}
}
