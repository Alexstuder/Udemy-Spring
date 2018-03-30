package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			
			
			Student tempStudent = new Student("Daffy","Duck","daffy@gmx.com");
			
			// Start a transaction
			session.beginTransaction();
			// save the student object
			System.out.println("Saving the Student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			
			session.getTransaction().commit();
			
			
			//
			// find out the student'sid : primary KEy
			System.out.println("Saved student. Generated id:" + tempStudent.getId());

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id : primary Key
			System.out.println("\nGetting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get complete : " + myStudent);
			
			session.getTransaction().commit();
			
			
			
			// commit the transaction
			
			
			
			
			System.out.println("Done");
			
		} finally {

			factory.close();
		}
		
	}

}
