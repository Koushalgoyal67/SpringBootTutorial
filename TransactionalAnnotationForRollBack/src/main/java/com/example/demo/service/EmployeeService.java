package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.model.Employee;

@Service
public class EmployeeService {

	EmployeeRepo employeeRepo;
	private Employee employee=new Employee();
	
	EmployeeService(EmployeeRepo employeeRepo ){
		this.employeeRepo=employeeRepo;
	}
	
	public void saveWithoutTransactional()  {
			employeeRepo.save(employee
					.setId(2)
					.setFirstName("Lokesh")
					.setLastName("Goyal"));
	}
	@Transactional(rollbackFor = Exception.class) //need to use rollbackFor Exception otherwise rollback will not work for unchecked Exceptions
	public void saveWithTransactional()throws Exception {
		employeeRepo.save(employee
				.setId(1)
				.setFirstName("Koushal")
				.setLastName("Goyal"));
		int a=2/0;  //will throw Arithmetic Exception and will cause rollback, you can check whether rollback happens or by removing rollbackfor =Exception.class ,then it will save in db without any rollback
	}
}



