package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		
		// create Session factory
 
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		
		// create Session
		
		Session session = factory.getCurrentSession();
		
		try {
            // start a transaction
			session.beginTransaction();
			
			int id = 1;
			// save the instructor
			Instructor tempInstructor = session.get(Instructor.class,id );
			
			
			System.out.println("Found Instructor="+tempInstructor);
			
			if (tempInstructor != null) {
				
				System.out.println("Deleting" + tempInstructor);
				session.delete(tempInstructor);
				
			}
			
			session.getTransaction().commit();
			
			
			
			//commit the transaction
			session.close();
			
			
		} catch(Exception exc) {
			exc.printStackTrace();
			
		}
		
		finally {

			factory.close();
		}
		
	}

}
