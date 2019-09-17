package com.example.demo.model;

import javax.persistence.Id;

//import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Student1")
@Data
public class StudentMongo {

	@Id
	int id;
	
	String name;
	
}
