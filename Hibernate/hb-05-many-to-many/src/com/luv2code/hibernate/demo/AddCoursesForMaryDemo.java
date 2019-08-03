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

public class AddCoursesForMaryDemo {

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
			
			
		
			
			
            // get Mary from the Database 
			
			int id = 10 ;
 			Student mary = session.get(Student.class,id );
			
			
 			// create more courses
            Course moreCourse = new Course("Blender Programming");
            Course moreCourse2 = new Course("Swift Programming");
			
			
			// add mary to those
            
            moreCourse.addStudents(mary);
            moreCourse2.addStudents(mary);
           
            
            
            // save the courses
            System.out.println("\nSaving the Courses");
            session.save(moreCourse);
            session.save(moreCourse2);
			
			
			
			
			
			
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
