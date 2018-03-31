package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		
		// create Session factory
 
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		// create Session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// use the session to save  Java Objects
					
			// create a student Object
			System.out.println("Create new Student object...");
			
			String theDateOfBirhtStr = "29/03/1966";
			Date  theDateOfBirth = DateUtils.parseDate(theDateOfBirhtStr);
			Student tempStudent = new Student("Paul","Wall","peter@gmx.com",theDateOfBirth);
			
			// Start a transaction
			session.beginTransaction();
			// save the student object
			System.out.println("Saving the Student");
			
			session.save(tempStudent);
			
			// commit transaction
			
			session.getTransaction().commit();
			System.out.println("Done");
			
		} catch(Exception exc) {
			exc.printStackTrace();
			
		}
		
		finally {

			factory.close();
		}
		
	}

}
