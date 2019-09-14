package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.LaptopRepo;
import com.example.demo.model.Laptop;
import com.example.demo.model.Student;

@RestController
public class LaptopController {

	@Autowired
	LaptopRepo laptopRepo;
	
    @GetMapping(value = "/laptop")
    public List<Laptop> update() {

        Laptop laptop = new Laptop();

        Student student = new Student();
        student.setRollno(2);
        student.setName("");
        student.setMarks(50);
   


        laptop.setLid(11111);
        laptop.setLname("Dell");
        //laptop.setStudent(student);

        laptopRepo.save(laptop);

        return laptopRepo.findAll();


    }
}
