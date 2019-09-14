package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import com.example.demo.service.UploadService;

@Controller
public class ThyemeleafController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private UploadService uploadService;
	
	
    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "/home/auriga/Videos/";
    
	//@Value("${welcome.message}")
	private String message="hello";
	
    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
	@GetMapping("/")
	public String show(Model model) {
		model.addAttribute("message", message);
		model.addAttribute("tasks", tasks);
		return "upload"; //View
	}
	
	
	
	@GetMapping("/student")
	public String get(Model model) {
		Student student=studentService.getStudent(3);

		model.addAttribute("id", student.getId());
		model.addAttribute("name", student.getName());
		return "welcome"; //View
	}
	
	@GetMapping("/student/all")
	public String getAll(Model model) {
		List<Student> student=studentService.getAllStudent(3);

		model.addAttribute("id", student.get(0).getId());
		model.addAttribute("name", student.get(1).getName());
		model.addAttribute("students",student);
		return "welcome2"; //View
	}
	
	//image upload
    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) {
    	uploadService.upload(file,redirectAttributes);
        return "redirect:/uploadStatus";
    }
    
    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
}
