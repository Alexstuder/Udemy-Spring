package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetCoursesInstructorDemo {

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
			
            // start a transaction
			session.beginTransaction();
			
			int id = 10;
			
			Course tempCourse = session.get(Course.class, id);
			
			System.out.println("Course :" + tempCourse);
			
			
			System.out.println("Insructor :" + tempCourse.getInstructor());
			
			
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
