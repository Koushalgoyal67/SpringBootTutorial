package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.EmployeeContact;

@RepositoryRestResource(collectionResourceRel="contact",path="contatct")
public interface EmployeeContactRepo extends JpaRepository<EmployeeContact, Integer>{

}
