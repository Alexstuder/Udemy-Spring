package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// need a controller method to show the inital HTML
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// need a controller to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	// new controller method to read form data
	// and add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		// read the request parameter from the HTML Form
		String theName = request.getParameter("studentName");

		// Convert the data to all caps
		theName = theName.toUpperCase();

		// create the message

		String result = "Yo! " + theName;

		// add the message to the model
		model.addAttribute("message", result);

		return "helloworld";

	}

	// new controller method to read form data
	// and add data to the model
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		// No longer needed because of the @Request Param
//		String theName = request.getParameter("studentName");
		
		// Convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		
		String result = "Hey this is Version 3 with RequestParameter " + theName;
		
		// add the message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
		
	}

}
