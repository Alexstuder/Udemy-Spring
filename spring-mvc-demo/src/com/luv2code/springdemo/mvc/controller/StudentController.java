package com.luv2code.springdemo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.mvc.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		// create a student
		Student theStudent = new Student();
		
		// add Student object to the modell
		model.addAttribute("student", theStudent);
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		
		// log the input data
		System.out.println("theStudent" + theStudent.getFirstName()
		                    + theStudent.getLastName()
		);
		return "student-confirmation";
	}
	
	

}
