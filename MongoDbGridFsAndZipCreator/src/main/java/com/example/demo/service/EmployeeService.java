package com.example.demo.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.EmployeeRepo;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.Employee;

@Service
public class EmployeeService {
	
    @Autowired
    public EmployeeRepo employeeRepo;
    
//    EmployeeService(EmployeeRepo employeeRepo){
//    	this.employeeRepo=employeeRepo;
//    }

	public EmployeeDto getAllEmployee() {
		// TODO Auto-generated method stub
		try { 
		return  new EmployeeDto().setData(employeeRepo.findAll());
		
		}
		catch(Exception e) {}
		
		return null;
	}

	public void postMultipleEmployee(EmployeeDto employeeDto) {		
		employeeDto.getData().stream()
							 .filter(employee->Pattern.matches("\\d{1,2}", employee.getId()+""))
							 .filter(employee->!employeeRepo.findById(employee.getId()).isPresent())
							 .forEach(employee->employeeRepo.save(new Employee().setId(employee.getId())
																				.setName(employee.getName())		
															 )
							 );
		//or
		
//		employeeDto.getData().forEach(employee->{   if(Pattern.matches("\\d{1,7}", employee.getId()+""))
//														if(!employeeRepo.findById(employee.getId()).isPresent())
//															employeeRepo.save(new Employee().setId(employee.getId())
//																				            ß.setName(employee.getName())		
//															);
//															
//							  });
//		
	
	}
	
	
}
