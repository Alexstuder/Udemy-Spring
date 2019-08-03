package com.luve2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luve2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;
	
	// define @PostConstructir to load the student data only once !
	
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<Student>();
		
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Mary", "Smiths"));
		
	}
	
	
	// define endpoint "/students" return list of students
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		
		return theStudents;
	}
	
	// define endpoint for "/students/{studentID}" - return student at index
	@GetMapping("/students/{studentID}")
	public Student getStudent(@PathVariable int studentID) {
		
		//just index into the list 
		return theStudents.get(studentID);
		
	}
	
}
