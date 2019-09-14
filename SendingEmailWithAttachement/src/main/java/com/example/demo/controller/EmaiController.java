package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.EmailService;

@Controller
 class EmailController {

	@Autowired
	private EmailService emailService;
	
	
	@GetMapping("/email")
	public String emailPage() {
		return "email";
	}
	
	@PostMapping("/email/send")
    public String sendEmail(@RequestParam("emailBody") String emailBody,@RequestParam("receiverEmail") String receiverEmail,@RequestParam("emailSubject") String emailSubject,@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) {

			System.out.println("Sending Email...");
        	emailService.sendEmail(receiverEmail,emailSubject,emailBody,file);

        System.out.println("Done");
        return "welcome2";

    }



}
