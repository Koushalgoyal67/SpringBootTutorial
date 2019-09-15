package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="EmployeeContact")
public class EmployeeContact {

		@Id
		@GeneratedValue
		private int conatctId;
		

		
		private String mobile;

		@JsonBackReference
		@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
		@JoinColumn(name="empId",referencedColumnName = "empId")
		EmployeeDetails employeeDetails ;
		
		
		public EmployeeDetails getEmployeeDetails() {
			return employeeDetails;
		}

		public void setEmployeeDetails(EmployeeDetails employeeDetails) {
			this.employeeDetails = employeeDetails;
		}
		
		

		public int getConatctId() {
			return conatctId;
		}

		public void setConatctId(int conatctId) {
			this.conatctId = conatctId;
		}



		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		@Override
		public String toString() {
			return "EmployeeContact [conatctId=" + conatctId + ", mobile=" + mobile + ", employeeDetails="
					+ employeeDetails + "]";
		}
		

}
