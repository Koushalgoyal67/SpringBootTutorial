package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.dao.GenderRepo;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.EmployeeWrapperDto;
import com.example.demo.model.Employee;
import com.example.demo.model.Gender;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	private GenderRepo genderRepo;
	
	@GetMapping("/all")
	public EmployeeWrapperDto getAllEmployee() {
//		for(int i=0;i<20;i++) {
//			employeeRepo.save(new Employee().setName("bye-"+i));
//		}
		
		List<EmployeeDto> list = new ArrayList<>();
		
		for(int i=0;i<employeeRepo.findAll().size();i++) {
/* employee dto object needed to be declared localy as this time we are adding objects into list 
 * and list store reference of object not value , so if we define it globally the whole list get overrided by last 
 * values in object , list will contain maximum of i elements but all are with same value,
 * In case when we save data in this loop , then value get saved in db not reference of object , so in case of db save 
 * can declare this object globally.
 * 
 */
			EmployeeDto employeeDto=new EmployeeDto();   
			employeeDto.setEmpName(employeeRepo.findAll().get(i).getName())
					   .setEmpId(employeeRepo.findAll().get(i).getEmpId())
					   .setGender(employeeRepo.findAll().get(i).getGender().getGender())
					   .setGenderId(employeeRepo.findAll().get(i).getGender().getGenderId());
			list.add(employeeDto);
		}
		return new EmployeeWrapperDto().setEmployeeDto(list);
	}
	
	@GetMapping("/all/gender")
	public List<Gender> getAllEmployeeGender() {
		for(int i=0;i<20;i++) {
			genderRepo.save(new Gender().setEmployee(new Employee().setName("bye-"+i)));
		}
		return genderRepo.findAll();
	}
	
}
