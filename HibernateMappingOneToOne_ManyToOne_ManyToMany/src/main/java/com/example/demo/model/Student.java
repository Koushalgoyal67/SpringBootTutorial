package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Student")
public class Student {

	    @Id
		private int rollno;
	    
	    private String name;
	    private int marks;
	    
//	    @OneToOne(cascade = CascadeType.ALL)
//	    @JoinColumn(name = "lid", referencedColumnName = "lid") 
//	    private Laptop laptop;  // here lid will behave like foriegn key
//		public Laptop getLaptop() {
//			return laptop;
//		}
//		public void setLaptop(Laptop laptop) {
//			this.laptop = laptop;
//		}
	   
//	    @JsonManagedReference
//	    @OneToMany(mappedBy="student",fetch=FetchType.LAZY,cascade = CascadeType.ALL) // student variable in laptop model
//	    @NotFound(action = NotFoundAction.IGNORE)
//	    //@JoinColumn(name="lid" ,referencedColumnName = "lid")
//	    private List<Laptop> laptop= new ArrayList<>();
//		public List<Laptop> getLaptop() {
//			return laptop;
//		}
//		public void setLaptop(List<Laptop> laptop) {
//			this.laptop = laptop;
//		}
		
	    
	    @JsonManagedReference
	    @ManyToMany(mappedBy="student",fetch=FetchType.LAZY,cascade = CascadeType.ALL) // student variable in laptop model
	    @NotFound(action = NotFoundAction.IGNORE)
	    //@JoinColumn(name="lid" ,referencedColumnName = "lid")
	    private List<Laptop> laptop= new ArrayList<>();
		public List<Laptop> getLaptop() {
			return laptop;
		}
		public void setLaptop(List<Laptop> laptop) {
			this.laptop = laptop;
		}
		
		
		public int getRoll() {
			return rollno;
		}
		public void setRollno(int rollno) {
			this.rollno = rollno;
		}

		public int getRollno() {
			return rollno;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getMarks() {
			return marks;
		}
		public void setMarks(int marks) {
			this.marks = marks;
		}
	    
		
		
}
