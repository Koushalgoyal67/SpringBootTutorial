package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepo;
import com.example.demo.model.Student;

@Service
@Transactional
public class StudentService {

	private StudentRepo studentRepo ;
	
	StudentService(StudentRepo studentRepo ){
		this.studentRepo=studentRepo;
	}
	
	@CachePut(value = "mycache", key="#id")
	public void postStudent(int id,Student  student) {
		studentRepo.save(student);
	}
	
	
	//@Cacheable(value = "mycache", key="#id")
	public List<Student> getStudent(int id){
		
		//new Student(1,"Koushal");
		List<Student> list = new ArrayList<>();
		try {
			Thread.sleep(1000*5);
			
			for (Student employeeDetails : studentRepo.findAll()) {
				list.add(employeeDetails);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
