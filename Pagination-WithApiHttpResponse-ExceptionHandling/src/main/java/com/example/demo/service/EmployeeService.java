package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Employee;

 
@Service
public class EmployeeService {
     
    @Autowired
    EmployeeRepo employeeRepo;
     
    public EmployeeDto getAllEmployees(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<Employee> pagedResult = employeeRepo.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return new EmployeeDto().setData(pagedResult.getContent());
        } else {
            return null;
        }
    }
     
    public EmployeeDto getEmployeeById(int id) throws RecordNotFoundException
    {
        Optional<Employee> employee = employeeRepo.findById(id);
         
        if(employee.isPresent()) {
        	List<Employee> list= new ArrayList();
        	list.add(employee.get());
            return new EmployeeDto().setData(list);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public EmployeeDto createOrUpdateEmployee(EmployeeDto employeeDto) throws RecordNotFoundException
    {
    	Iterable<Employee> employee2 = employeeDto.getData();
    	Iterator<Employee> itr =employee2.iterator();
    	List<Employee> list= new ArrayList();
    	
    	while(itr.hasNext()) {
    		Employee emp=itr.next();
	        Optional<Employee> employee = employeeRepo.findById(emp.getId());
	        if(employee.isPresent()) {
	            Employee newEntity = employee.get();
	            newEntity.setName(emp.getName());
	            newEntity = employeeRepo.save(newEntity);
	        	list.add(newEntity);
	        } else 
	            list.add(employeeRepo.save(emp));
	        
    	}
    	return new EmployeeDto().setData(list);
    }
     
    public void deleteEmployeeById(int id) throws RecordNotFoundException
    {
        Optional<Employee> employee = employeeRepo.findById(id);
         
        if(employee.isPresent())
        {
        	employeeRepo.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

	public EmployeeDto saveRecords() {
    	for(int i=0;i<1000;i++) {
    		Employee employee = new Employee();
    		employee.setName("abc"+i);
    		employeeRepo.save(employee);	
    	}
    	
    	
		return new EmployeeDto().setData(employeeRepo.findAll());
	}
}