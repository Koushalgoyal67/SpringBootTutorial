package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class EmployeeLocation {
	@Id
	//@GeneratedValue
	private int locationId;
	
	private String city;
	
	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private EmployeeDetails employeeDetails;
	
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "empId", referencedColumnName = "empId") 
//    private EmployeeDetails employeeDetails;  // here locationId will behave like foriegn key
//
	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	
	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	

	

}
