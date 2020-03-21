package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	//table name should be same as entity name on model and same in case of columns
	@Query( "select emp from employee emp where id>2")
	List<Employee> findAllEmployee(); // or we can use Object[] as a generic
	
	
	@Query( "select emp.lastName ,emp.firstName from employee emp where id=?1")
	Optional<Employee> findEmployeeById(Integer id);
	
	@Query( "select emp.lastName ,emp.firstName from employee emp where id>1")
	List<Object[]> findMultipleEmployee();
}


//@Query(value = "from employee", nativeQuery = true)  //sql query