package com.luv2code.hibernate.demo;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeletePacManCourseDemo {

	public static void main(String[] args) {
		
		
		// create Session factory
 
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		// create Session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			
            // start a transaction
			session.beginTransaction();
			
			
            // get the PacMAnCourse from DB 
			
			int id = 23 ;
 			Course tmpCourse = session.get(Course.class, id);
 			
 			// delete the course
 			
 			System.out.println("Deleting the course" + tmpCourse);
 			session.delete(tmpCourse);
			
 			
 			
			
			
			
			
			
			
			//commit the transaction
			System.out.println("Session Will be Commited");
			session.getTransaction().commit();
			System.out.println("Session Commited");
			
			
			System.out.println("Done!");
			
		} catch(Exception exc) {
			exc.printStackTrace();
			
		}
		
		finally {

			session.close();
			System.out.println("Session Closed");
			factory.close();
			System.out.println("Factory Closed");
		}
		
	}

}
