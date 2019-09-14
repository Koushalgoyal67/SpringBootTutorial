package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.HibernateModel;
@RepositoryRestResource(collectionResourceRel="aliens",path="aliens")
public interface HibernateRepo extends JpaRepository<HibernateModel,Integer> {

}
