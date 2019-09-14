package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
final public class Student {
	
	@Id
	 int id;
	
	@Column(name="name")
	 String name;
	
	@Column(name="address")
	 String address;

	Student(){}
	 public Student(Builder builder) 
	    { 
	        this.id = builder.id; 
	        this.name = builder.name; 
	        this.address = builder.address; 
	    } 
	 
	    // Static class Builder 
	    public static class Builder { 
	  
	        /// instance fields 
	        private int id; 
	        private String name; 
	        private String address; 
	  
	        public static Builder newInstance() { 
	            return new Builder(); 
	        } 
	  
	        private Builder() {} 
	  
	        // Setter methods 
	        public Builder setId(int id) { 
	            this.id = id; 
	            return this; 
	        } 
	        public Builder setName(String name) { 
	            this.name = name; 
	            return this; 
	        } 
	        public Builder setAddress(String address)  { 
	            this.address = address; 
	            return this; 
	        } 
	  
	        // build method to deal with outer class 
	        // to return outer instance 
	        public Student build() { 
	            return new Student(this); 
	        } 
	    }

	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
		} 
	    
	    

}
