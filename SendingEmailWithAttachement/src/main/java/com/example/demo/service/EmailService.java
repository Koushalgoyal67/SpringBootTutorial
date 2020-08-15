package com.example.demo.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class EmailService {

	  @Autowired
	  JavaMailSender javaMailSender;
	  
	public String sendEmail(String receiverEmail,String emailSubject,String emailBody,MultipartFile file) {
		try {
		//sendNormalEmail(receiverEmail,emailSubject,emailBody);
		sendEmailWithAttachment(receiverEmail,emailSubject,emailBody,file);
		}
		catch(Exception e) {e.printStackTrace();}
		return"success";
	}
	
    void sendNormalEmail(String receiverEmail,String emailSubject,String emailBody) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("koushal.goyal@aurigait.com",receiverEmail);

        msg.setSubject(emailSubject);
        msg.setText(emailBody);

        javaMailSender.send(msg);

    }

    void sendEmailWithAttachment(String receiverEmail,String emailSubject,String emailBody,MultipartFile file) throws MessagingException, IOException, javax.mail.MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        //byte[] bytes = file.getBytes(); 
        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(receiverEmail);
        //helper.setFrom("koushal.goyal@cointribe.com");  // use this in case of outlook
        helper.setSubject(emailSubject);

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText(emailBody, true);

        //FileSystemResource file = new FileSystemResource(new File("classpath:android.png"));

        //Resource resource = new ClassPathResource("android.png");
        //InputStream input = resource.getInputStream();

        //ResourceUtils.getFile("classpath:android.png");

        helper.addAttachment("photo.png", new ClassPathResource("android.png"));

        javaMailSender.send(msg);

    }
}




