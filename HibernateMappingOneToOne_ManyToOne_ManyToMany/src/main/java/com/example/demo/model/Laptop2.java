package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Laptop2")
public class Laptop2 {

	    @Id 
		private int lid;
		private String lname;
		
//		@JsonBackReference
//		@ManyToOne//(fetch=FetchType.LAZY)
//		@JoinColumn(name="rollno",referencedColumnName = "rollno")
//		Student student ;
//		
//		
//		public Student getStudent() {
//			return student;
//		}
//		public void setStudent(Student student) {
//			this.student = student;
//		}
		
		
		public int getLid() {
			return lid;
		}
		public void setLid(int lid) {
			this.lid = lid;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		@Override
		public String toString() {
			return "Laptop2 [lid=" + lid + ", lname=" + lname + "]";
		}
		
		
}
