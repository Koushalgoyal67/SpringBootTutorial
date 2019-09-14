package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Laptop;

public interface LaptopRepo extends JpaRepository<Laptop, Integer>{

}
