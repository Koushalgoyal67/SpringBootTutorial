package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="EmployeeDetails") 
public class EmployeeDetails {

	@Id
	//@GeneratedValue
	private int empId;
	
	private String empName;
	
	@OneToOne(mappedBy="employeeDetails", cascade=CascadeType.ALL)
	private EmployeeLocation employeeLocation;
	
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "locationId", referencedColumnName = "locationId") 
//    private EmployeeLocation employeeLocation;  // here locationId will behave like foriegn key
//
	public EmployeeLocation getEmployeeLocation() {
		return employeeLocation;
	}

	public void setEmployeeLocation(EmployeeLocation employeeLocation) {
		this.employeeLocation = employeeLocation;
	} 
	

    @JsonManagedReference   //they are used to basically stop recursion while fetching data from api but cause post api to stop work
    @OneToMany(mappedBy="employeeDetails",fetch=FetchType.LAZY,cascade = CascadeType.ALL) // student variable in laptop model
    @NotFound(action = NotFoundAction.IGNORE)
    //@JoinColumn(name="lid" ,referencedColumnName = "lid")
    private List<EmployeeContact> employeeContact= new ArrayList<>();
    
	public List<EmployeeContact> getEmployeeContact() {
		return employeeContact;
	}

	public void setEmployeeContact(List<EmployeeContact> employeeContact) {
		this.employeeContact = employeeContact;
	}

    //@JsonManagedReference
    @ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL) // student variable in laptop model
    @JoinTable(name="skills_employee_details",joinColumns= {
    		@JoinColumn(name="employee_details_emp_id",nullable=false)},inverseJoinColumns={
    	    		@JoinColumn(name="skills_lid",nullable=false)
    })
    private List<Skills> skills= new ArrayList<>();
    
    

	public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}

	
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [empId=" + empId + ", empName=" + empName + ", employeeLocation=" + employeeLocation
				+ ", employeeContact=" + employeeContact + ", skills=" + skills + "]";
	}




	


}
