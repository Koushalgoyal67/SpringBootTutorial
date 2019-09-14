package com.example.demo.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Employee;

public interface EmployeeRepo extends MongoRepository<Employee, Integer>{

}
