package com.koushal.sceureapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koushal.sceureapp.dao.UserRepository;
import com.koushal.sceureapp.model.User;

@RestController
@RequestMapping("api/public")
public class PublicRestApiController {
	
	@Autowired
    private UserRepository userRepository;

//    public PublicRestApiController(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }

    @GetMapping("test1")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("test2")
    public String test2(){
        return "API Test 2";
    }

    @GetMapping("users")
    public List<User> users(){
        return this.userRepository.findAll();
    }
    
    // Available to all authenticated users
    @GetMapping("test")
    public String test(){
        return "API Test";
    }

    // Available to managers
    @GetMapping("management/reports")
    public String reports(){
        return "Some report data";
    }

    // Available to ROLE_ADMIN
    @GetMapping("admin/users")
    public List<User> adminUsers(){
        return userRepository.findAll();
    }

}

