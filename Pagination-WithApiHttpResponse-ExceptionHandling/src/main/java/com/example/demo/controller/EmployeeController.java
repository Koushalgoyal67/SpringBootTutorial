package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController
{
    @Autowired
    EmployeeService employeeService;
    

 
 
    @GetMapping
    public ResponseEntity<EmployeeDto> getAllEmployees(
                        @RequestParam(defaultValue = "3") Integer pageNo,
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        @RequestParam(defaultValue = "id") String sortBy)
    {
        EmployeeDto list = employeeService.getAllEmployees(pageNo, pageSize, sortBy);
 
        return new ResponseEntity<EmployeeDto>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") int id) throws RecordNotFoundException {
        EmployeeDto entity = employeeService.getEmployeeById(id);
 
        return new ResponseEntity<EmployeeDto>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<EmployeeDto> createOrUpdateEmployee(@RequestBody EmployeeDto employeeDto) throws RecordNotFoundException {
        EmployeeDto updated = employeeService.createOrUpdateEmployee(employeeDto);
        return new ResponseEntity<EmployeeDto>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") int id)throws RecordNotFoundException {
    	employeeService.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }
    
    @GetMapping("/save")
    public ResponseEntity<EmployeeDto> saveRecords() {
    	EmployeeDto list=employeeService.saveRecords();
    	return new ResponseEntity<EmployeeDto>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
}