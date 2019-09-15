package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.EmployeeDetails;

//@RepositoryRestResource(collectionResourceRel="deatil",path="detail")
public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetails, Integer> {

}
