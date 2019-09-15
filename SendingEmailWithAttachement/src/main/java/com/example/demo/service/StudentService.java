package com.example.demo.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepo;
import com.example.demo.model.Student;

@Service
@Transactional
public class StudentService {

	private StudentRepo studentRepo ;
	private Student s;
	
	StudentService(StudentRepo studentRepo ){
		this.studentRepo=studentRepo;
	}
	
	@CachePut(value = "mycache", key="#id")
	public void postStudent(int id,Student  student) {
		studentRepo.save(student);
	}
	
	
	//@Cacheable(value = "mycache", key="#id")
	public Student getStudent(int id){
		studentRepo.save(new Student(1,"Koushal"));
		try {

			Optional<Student> optional=studentRepo.findById(id); 
			if(optional.isPresent()) {
				 s= optional.get();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	//@Cacheable(value = "mycache", key="#id")
	public List<Student> getAllStudent(int id){
		studentRepo.save(new Student(1,"Koushal"));
		List<Student> student=null;
		try {

			student=studentRepo.findAll().stream().sorted(Comparator.comparing(Student::getId)).collect(Collectors.toList()); 

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return student;
	}
}
