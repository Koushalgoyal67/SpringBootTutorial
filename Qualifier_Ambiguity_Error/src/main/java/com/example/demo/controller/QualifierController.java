package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.interfaces.IQualifierService;

@RestController
public class QualifierController {

	@Autowired @Qualifier("service2")
	private IQualifierService iQualfierService;
	
	@GetMapping("/get")
	public String getMsg() {
		return iQualfierService.getMsg();
	}
}
