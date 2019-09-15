package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentRepo;
import com.example.demo.model.Laptop;
import com.example.demo.model.Student;

@RestController
public class StudentController {

	@Autowired
	StudentRepo studentRepo;
	
    @GetMapping(value = "/student/all")
    public List<Student> getUsersContact() {
        return studentRepo.findAll();
    }
    
    @GetMapping(value = "/update/student")
    public List<Student> updateStudent() {
        return studentRepo.findAll();
    }
    
//    @GetMapping(value = "/student/oneToOne")
//    public List<Student> update() {
//
//    	Laptop laptop = new Laptop();
//        laptop.setLid(1);
//        laptop.setLname("Dell");
//  
//        Student student = new Student();
//        student.setRollno(1);
//        student.setName("Koushal");
//        student.setMarks(50);
//        student.setLaptop(laptop); // for onetoone
//        laptop.setStudent(student);
//        studentRepo.save(student);
//        return studentRepo.findAll();
//    }
    
//    @GetMapping(value = "/student/oneToMany")
//    public List<Student> updateOneToMany() {
//
//    	Laptop laptop = new Laptop();
//        laptop.setLid(1);
//        laptop.setLname("Dell");
// 
//        
//        
//        Student student = new Student();
//        student.setRollno(1);
//        student.setName("Koushal");
//        student.setMarks(50);
//
//        student.getLaptop().add(laptop); // for one to many
//
//        laptop.setStudent(student);
//        studentRepo.save(student);
//        return studentRepo.findAll();
//
//    }
    
  @GetMapping(value = "/student/ManyToMany")
  public List<Student> updateOneToMany() {

  	Laptop laptop = new Laptop();
      laptop.setLid(1);
      laptop.setLname("Dell");

      
      
      Student student = new Student();
      student.setRollno(1);
      student.setName("Koushal");
      student.setMarks(50);

      student.getLaptop().add(laptop); // for one to many

      laptop.getStudent().add(student);
      studentRepo.save(student);
      return studentRepo.findAll();

  }
    
    
    
}

