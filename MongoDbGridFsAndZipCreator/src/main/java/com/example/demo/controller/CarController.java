package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.CarRepo;
import com.example.demo.model.Car;

@RestController
@RequestMapping("/rest")
public class CarController {

	@Autowired
	private CarRepo carRepo;
	
	@GetMapping("/all")
	public List<Car> getAll() {
		return carRepo.findAll();
	}
}
