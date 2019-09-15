package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.SkillsRepo;
import com.example.demo.model.Skills;

@RequestMapping(value="skills")
@CrossOrigin
@RestController
public class SkillsController {

	@Autowired
	SkillsRepo skillsRepo;
	
	@GetMapping(value="/all")
	public List<Skills> show(){
		return skillsRepo.findAll();
	}
	
}
