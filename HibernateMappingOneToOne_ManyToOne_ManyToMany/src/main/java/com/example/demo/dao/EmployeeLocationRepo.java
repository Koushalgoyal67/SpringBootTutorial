package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EmployeeLocation;

public interface EmployeeLocationRepo extends JpaRepository <EmployeeLocation,Integer>{

}
