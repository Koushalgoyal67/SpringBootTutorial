package com.example.demo.model;

import javax.persistence.Id;

//import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

//import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Student1")
@Data
@Builder
public class StudentMongo {

	@Id
	int id;
	
	String name;
	 
	@Tolerate
	public	StudentMongo(){}
}
