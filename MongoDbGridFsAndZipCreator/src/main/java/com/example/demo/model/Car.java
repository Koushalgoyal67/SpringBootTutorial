package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cars")
public class Car {

  private Integer id;

  private String make;

  private String model;

  private String description;

  public Car() {}



  public Car(Integer id, String make, String model, String description) {
	super();
	this.id = id;
	this.make = make;
	this.model = model;
	this.description = description;
}



public Integer getId() {
	return id;
}



public void setId(Integer id) {
	this.id = id;
}



public String getMake() {
    return make;
  } 

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setModel(String model) {
    this.model = model;
  }

} 