package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.StudentMySql;

public interface StudentMySqlRepo extends JpaRepository<StudentMySql, Integer>{

}
