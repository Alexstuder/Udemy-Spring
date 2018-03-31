package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create Session factory
		 
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				
				// create Session
				
				Session session = factory.getCurrentSession();
				
				
				
				try {
					String theDateOfBirhtStr = "29/03/1966";
					Date  theDateOfBirth = DateUtils.parseDate(theDateOfBirhtStr);
					// use the session to save  Java Objects
							
					// create 3 student Object
					System.out.println("Create new Student object...");
					
					
					Student tempStudent1 = new Student("Bonita","Applebum","bonita@gmx.com", theDateOfBirth);
					Student tempStudent2 = new Student("John","DOe","john@gmx.com", theDateOfBirth);
					Student tempStudent3 = new Student("Mary","Public","Mary@gmx.com", theDateOfBirth);
					
					// Start a transaction
					session.beginTransaction();
					// save the student object
					System.out.println("Saving the Student");
					
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					// commit transaction
					
					session.getTransaction().commit();
					System.out.println("Done");
					
				} catch (ParseException e) {
					e.printStackTrace();
				} finally {

					factory.close();
				}
		
		
	}

}
