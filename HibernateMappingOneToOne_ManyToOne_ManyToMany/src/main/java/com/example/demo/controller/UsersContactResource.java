package com.example.demo.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UsersContactRepository;
import com.example.demo.model.Users;
import com.example.demo.model.UsersContact;

@RequestMapping("/rest/userscontact")
@RestController
public class UsersContactResource {

    private UsersContactRepository usersContactRepository;

    public UsersContactResource(UsersContactRepository usersContactRepository) {
        this.usersContactRepository = usersContactRepository;
    }

    //or
//    @Autowired
//    UsersContactRepository usersContactRepository;
    
    @GetMapping(value = "/all")
    public List<UsersContact> getUsersContact() {
        return usersContactRepository.findAll();
    }

    @GetMapping(value = "/contact-name")
    public List<?> getUsersContactAndName() {
        return usersContactRepository.findContactAndName();
    }
    
    @GetMapping(value = "/update-contact-name")
    public int updateUsersContactName() {
        return usersContactRepository.updateUsersContact();
    }
    
    @GetMapping(value = "/delete-contact-name")
    public  int deleteUsersContactName() {
         return usersContactRepository.deleteUsersContact();  
    }
    
    // for multiple queries
    @GetMapping(value = "/delete-find-contact-name")
    public List<?> deleteFindUsersContactName() {
         usersContactRepository.deleteUsersContact();
        return usersContactRepository.findContactAndName();
    }
    
    @GetMapping(value = "/update/{name}")
    public List<UsersContact> update(@PathVariable final String name) {

        UsersContact usersContact = new UsersContact();

        Users users = new Users();
        users.setTeamName("Development")
                .setSalary(10000)
                .setName(name);


        usersContact.setPhoneNo(11111)
                .setUsers(users);

        usersContactRepository.save(usersContact);

        return usersContactRepository.findAll();


    }


}
