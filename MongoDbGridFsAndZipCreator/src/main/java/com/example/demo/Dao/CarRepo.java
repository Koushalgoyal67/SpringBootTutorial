package com.example.demo.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Car;

public interface CarRepo  extends MongoRepository<Car, Integer>{

}
