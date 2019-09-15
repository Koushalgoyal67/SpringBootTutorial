package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.dto.EmployeeColumnDto;
import com.example.demo.dto.EmployeeDataDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.Employee;

@Service
public class EmployeeService {

	EmployeeRepo employeeRepo;
	private Employee employee=new Employee();
	
	EmployeeService(EmployeeRepo employeeRepo ){
		this.employeeRepo=employeeRepo;
	}
	
	public Optional<Employee> getEmployee(int id) {
		return employeeRepo.findById(id);
	}
	
	public List<Employee> getEmployee() {
		return employeeRepo.findAll();
	}
	
	public List<Employee> getAllEmployee() {
		return employeeRepo.findAllEmployee();
	}

	public void postMultipleEmployee(EmployeeDto employeeDto) {

//		for(Employee employee:employeeDto.getData()) {
//			if(!employeeRepo.existsById(employee.getId()))
//			employeeRepo.save(new Employee().setId(employee.getId())
//											.setFirstName(employee.getFirstName())
//											.setLastName(employee.getLastName())
//											);
//		}
			//or
		employeeDto.getData().forEach((n) ->{ if(!employeeRepo.existsById(n.getId())) 
												employeeRepo.save(employee
														.setId(n.getId())
														.setFirstName(n.getFirstName())
														.setLastName(n.getLastName()));
											});

	}

	public List<Employee> getEmployeeByID(Integer id) {
		
		return employeeRepo.findEmployeeById(id).stream().collect(Collectors.toList());
	}
	
	//for selected columns
	public EmployeeColumnDto getMultipleEmployee() {
		//List<Object[]> list=employeeRepo.findMultipleEmployee();
		//System.out.println(list.get(0)[1]);
		List<EmployeeDataDto> list2=employeeRepo.findMultipleEmployee()
												.parallelStream()
												.map(
														a->new EmployeeDataDto()
														.setFirstName(a[1]+"")
														.setLastName(a[0]+""))
												.collect(Collectors.toList());
		return new EmployeeColumnDto().setData(list2).setToken("Hello");
	}
}



