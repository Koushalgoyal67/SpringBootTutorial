package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDetailsRepo;
import com.example.demo.model.EmployeeDetails;


@Service
@Transactional
public class EmployeeDetailService {

	private EmployeeDetailsRepo employeeDetailsRepo ;
	
	EmployeeDetailService(EmployeeDetailsRepo employeeDetailsRepo ){
		this.employeeDetailsRepo=employeeDetailsRepo;
	}
	
	@CachePut(value = "mycache", key="#id")
	public void postEmployeeDetails(int id,EmployeeDetails  employeeDetails) {
		employeeDetailsRepo.save(employeeDetails);
	}
	
	
	@Cacheable(value = "mycache", key="#id")
	public List<EmployeeDetails> getEmployeeDetails(int id){
		List<EmployeeDetails> list = new ArrayList<EmployeeDetails>();
		try {
			Thread.sleep(1000*5);
			
			for (EmployeeDetails employeeDetails : employeeDetailsRepo.findAll()) {
				list.add(employeeDetails);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Cacheable(value = "mycache", key="#id")
	public List<EmployeeDetails> getEmployeeDetails2(int id){
		List<EmployeeDetails> list = new ArrayList<EmployeeDetails>();
		try {
			Thread.sleep(1000*5);
			
			for (EmployeeDetails employeeDetails : employeeDetailsRepo.findAll()) {
				list.add(employeeDetails);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteEmployeeDetails(int id) {
		employeeDetailsRepo.deleteById( id);
	}
}
