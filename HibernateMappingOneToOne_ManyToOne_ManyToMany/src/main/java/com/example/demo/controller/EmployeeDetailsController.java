package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDetailsRepo;
import com.example.demo.dao.Laptop2Repo;
import com.example.demo.model.EmployeeContact;
import com.example.demo.model.EmployeeDetails;
import com.example.demo.model.EmployeeLocation;
import com.example.demo.model.Laptop2;
import com.example.demo.model.Skills;
import com.example.demo.service.EmployeeDetailService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
@CrossOrigin
@RestController
public class EmployeeDetailsController {
	@Autowired
	EmployeeDetailsRepo employeeDetailsRepo;
	@Autowired
	private EmployeeDetailService employeeDetailService;
	
	
	@GetMapping(value="/employee-all")
	public List<EmployeeDetails> get(){
		return employeeDetailService.getEmployeeDetails(5);
	}
	
	@GetMapping(value="/employee-all2")
	public List<EmployeeDetails> get2(){
		return employeeDetailService.getEmployeeDetails(6);
	}
	
    @PostMapping(value="/post-details")
    public  EmployeeDetails post(@RequestBody EmployeeDetails employeeDetails) 
    {
    	//System.out.println("Hi "+employeeDetails.toString());
    	employeeDetailService.postEmployeeDetails(5,employeeDetails);
 	    return employeeDetails;
    } 
    
    @DeleteMapping("/employee-all/delete/{id}")
    public void delete(@PathVariable int id) {
    	employeeDetailService.deleteEmployeeDetails(id);
    }
	
	//shows one to many or many to one
    @GetMapping(value = "/employee-contact")
    public List<EmployeeDetails> update() {

    	EmployeeContact employeeContact = new EmployeeContact();
    	employeeContact.setConatctId(1);
    	employeeContact.setMobile("88354354");
 
 
    	EmployeeDetails employeeDetails = new EmployeeDetails();
    	employeeDetails.setEmpId(1);
    	employeeDetails.setEmpName("Koushal");

        
     	employeeDetails.getEmployeeContact().add(employeeContact); // for one to many

     	employeeContact.setEmployeeDetails(employeeDetails);
    	employeeDetailsRepo.save(employeeDetails);

        return employeeDetailsRepo.findAll();


    }
    
    //Shows one to one
    @GetMapping(value = "/employee-location")
    public List<EmployeeDetails> updateLocation() {

    	EmployeeLocation employeeLocation = new EmployeeLocation();
    	employeeLocation.setLocationId(1);
    	employeeLocation.setCity("Delhi");
 
 
    	EmployeeDetails employeeDetails = new EmployeeDetails();
    	employeeDetails.setEmpId(1);
    	employeeDetails.setEmpName("Koushal");
    	employeeDetails.setEmployeeLocation(employeeLocation); // for onetoone
        
    	employeeDetailsRepo.save(employeeDetails);

        return employeeDetailsRepo.findAll();


    }
    
    //Shows ManyToMAny relationship
    @GetMapping(value = "/employee-skill")
    public List<EmployeeDetails> updateSkills() {

    	Skills skills = new Skills();
    	skills.setLid(1);
    	skills.setLanguage("JavA");
 
 
    	EmployeeDetails employeeDetails = new EmployeeDetails();
    	employeeDetails.setEmpId(1);
    	employeeDetails.setEmpName("sarthak");
    	employeeDetails.getSkills().add(skills); // for ManyToMany
    	
    	skills.getEmployeeDetails().add(employeeDetails);
        
    	employeeDetailsRepo.save(employeeDetails);

        return employeeDetailsRepo.findAll();


    }
    

    

    
    @PutMapping(path="/put-deatils/{putId}")
    public EmployeeDetails putDetails(@PathVariable int putId,@RequestBody EmployeeDetails employeeDetails) throws JsonParseException, JsonMappingException, IOException {
    	//System.out.println("Hi "+employeeDetails+"bye "+employeeDetails.toString());
    	
        return employeeDetailsRepo.findById(putId).map(put -> {
            put.setEmpId(employeeDetails.getEmpId());
            put.setEmpName(employeeDetails.getEmpName());
        	EmployeeLocation employeeLocation = new EmployeeLocation();
        	employeeLocation.setLocationId(employeeDetails.getEmployeeLocation().getLocationId());
        	employeeLocation.setCity(employeeDetails.getEmployeeLocation().getCity());
     
     
        	//EmployeeDetails employeeDetails = new EmployeeDetails();
//        	employeeDetails.setEmpId(1);
//        	employeeDetails.setEmpName("Koushal");
        	put.setEmployeeLocation(employeeLocation); // for onetoone
            
        	//employeeDetailsRepo.save(employeeDetails);
            return employeeDetailsRepo.save(put);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + putId + " not found"));
    	//return employeeDetailsRepo.save(employeeDetails);
    } 
    
    
    @Autowired
    Laptop2Repo laptop2Repo;
    @GetMapping(value="laptop2")
    public List<Laptop2> showData(){
    	
    	return laptop2Repo.findAll();
    }
    
    @PostMapping(path="/post/laptop2")
    public void postLaptop(@Valid @RequestBody Laptop2 laptop2) {
    	laptop2Repo.save(laptop2);
    }
    



}




////WILL POST TODAY MATCH DETAIL IN SQL
//@PostMapping(path="/post/employee-contact",consumes= {"application/json"})
//public  EmployeeDetails addTodayMatch(Http@Valid @RequestBody EmployeeContact employeeDetails2) 
//{
//	System.out.println("hello "+employeeDetails2.toString());
//	EmployeeContact employeeContact = new EmployeeContact();
//	employeeContact.setConatctId(1);
//	employeeContact.setMobile("88354354");
//	Enumeration<String> enum1 =req.getParameterNames();
//	while(enum1.hasMoreElements())
//	{
//		System.out.println("bye "+req.getParameterValues(enum1.nextElement()));
//	}
//	
//	Enumeration<String> enum2 =req.getAttributeNames();
//	while(enum2.hasMoreElements())
//	{
//		System.out.println("hi "+req.getAttribute(enum2.nextElement()));
//	}
//	
//  //  System.out.println("hello "+employeeDetails2.toString()); 
//    
//
//	EmployeeDetails employeeDetails = new EmployeeDetails();
//	employeeDetails.setEmpId(1);
//	employeeDetails.setEmpName("Koushal");
//
//    
// 	employeeDetails.getEmployeeContact().add(employeeContact); // for one to many
//
// 	employeeContact.setEmployeeDetails(employeeDetails);
//	//employeeDetailsRepo.save(employeeDetails);
//	employeeDetailsRepo.save(employeeDetails);
//	    return employeeDetails;
//}


//ObjectMapper objectMapper = new ObjectMapper();
//String jsonCarArray = employeeDetails.toString();
//		  "[{\n" + 
//		  "    \"empId\": 1,\n" + 
//		  "    \"empName\": \"Vishnu\",\n" + 
//		  "    \"employeeLocation\": {\n" + 
//		  "        \"locationId\": 1,\n" + 
//		  "        \"city\": \"Delhi\"\n" + 
//		  "    },\n" + 
//		  "    \"employeeContact\": [\n" + 
//		  "        {\n" + 
//		  "            \"conatctId\": 1,\n" + 
//		  "            \"mobile\": \"88354354\"\n" + 
//		  "        }\n" + 
//		  "    ],\n" + 
//		  "    \"skills\": []\n" + 
//		  "}]";
//		List<EmployeeDetails> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<EmployeeDetails>>(){});
//		System.out.println("hello"+listCar);
