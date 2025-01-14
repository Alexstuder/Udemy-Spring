package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

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
			
			// get the instructor detail object
			int id = 1;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, id);
			// print the instructor detail
			System.out.println(tempInstructorDetail);
			
			// print the associated instructor		
			System.out.println(tempInstructorDetail.getInstructor());
			
			
			
			// Commit
			session.getTransaction().commit();
			System.out.println("Done!");
			
			
			
		} catch(Exception exc) {
			exc.printStackTrace();
			
		}
		finally {
			
			//commit the transaction
			session.close();

			factory.close();
		}
		
	}

}
