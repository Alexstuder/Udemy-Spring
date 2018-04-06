package com.luv2code.springdemo.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.mvc.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	// add an initbinder .. to convert trim input strings
	
	// remove leading and trailing whitespace
	
	//resolve issue for our validation
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	// Customer für die leere From bereitstellen
	@RequestMapping("/showForm")
	public String showform(Model model) {

		model.addAttribute("customer", new Customer());
		return "/customer-form";
	}

	// Das eingegebene Object im Controller entgegen nehmen
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {

		// @Valid = Perform validation rules on Customer object
		// BindingResult = Results of validation placed in the BindingResult
		System.out.println(customer);

		System.out.println("Binding result :" + bindingResult);
		System.out.println("\n\n\n\n");
		// Validierung , Verarbeitung etc......

		if (bindingResult.hasErrors()) {

			return "customer-form";
		} else {

			return "customer-confirmation";
		}

	}

}
