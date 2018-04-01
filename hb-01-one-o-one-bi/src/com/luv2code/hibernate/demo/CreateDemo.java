package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

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
			
			// Create the Objects
			InstructorDetail myInstructorDetail = new InstructorDetail("www.youtube.com/Methyni", "Drohnes");
			Instructor myInstructor = new Instructor("Droni", "Drohnes", "drohnes@alex.com",myInstructorDetail);
			
			
			//associate the Objects
//            myInstructor.setInstructorDetail(myInstructorDetail);			
			
            // start a transaction
			session.beginTransaction();
			
			// save the instructor
			session.save(myInstructor);

			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, 5);
			
			System.out.println(tempInstructorDetail);
			System.out.println(tempInstructorDetail.getInstructor());
			
			
			
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
