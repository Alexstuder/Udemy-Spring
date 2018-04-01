package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		
		
		// create Session factory
 
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		
		// create Session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// Create the Objects
			Instructor myInstructor = new Instructor("Susanne", "Public", "susanne@public.com");
            // Create Details			
			InstructorDetail myInstructorDetail = new InstructorDetail("www.youtube.com/Gamer", "Games");
			
			//associate the Objects
             myInstructor.setInstructorDetail(myInstructorDetail);			
			
            // start a transaction
			session.beginTransaction();
			
			// save the instructor
			session.save(myInstructor);

		
			
			
			
			
			
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
			
		} catch(Exception exc) {
			exc.printStackTrace();
			
		}
		
		finally {

			session.close();
			factory.close();
		}
		
	}

}
