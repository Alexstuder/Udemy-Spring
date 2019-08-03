package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			int id = 4 ;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, id);
			// print the instructor detail
			System.out.println(tempInstructorDetail);
			
			// print the associated instructor		
			System.out.println(tempInstructorDetail.getInstructor());
			
			
			
			// Delete the InsructorDetail
			System.out.println("Delete the InstructorDetail:" + tempInstructorDetail);
			
			
			//remove the associated object reference
			//breake bi-directional link
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(tempInstructorDetail);
			
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
