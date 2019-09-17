package com.example.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.StudentMongo;

public interface StudentMongoRepo extends MongoRepository<StudentMongo, Integer>{

	
}
