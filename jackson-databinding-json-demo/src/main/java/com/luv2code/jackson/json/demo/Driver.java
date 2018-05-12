package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {
			
			//creat object mapper
			
			ObjectMapper mapper = new ObjectMapper();
			
			
			// read JSON file and convert to JAVA POJO
			
//			Student student = mapper.readValue(new File("data/sample-lite.json"), Student.class);
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			
			// print firstName and lastName
//			System.out.println("FirstName : " + student.getFirstName());
//			System.out.println("LastName : " + student.getLastName());
//			System.out.println("Address : " + student.getAddress());
//			System.out.println("Languages : " + student.getLanguages());
 			System.out.println("Student : " + student.toString());
			
			
			
			
		} catch (Exception exc) {

		  exc.printStackTrace();
		
		}
		
		
		
	}

}
