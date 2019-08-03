package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		
		// create Session factory
 
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		
		// create Session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			
            // start a transaction
			session.beginTransaction();
			
			
	        // create a course
			
			Course course = new Course("Pacman - How to score Million Points");
			// add some Review
			course.addReview(new Review("Greate Course"));
			course.addReview(new Review("Cool Course"));
			course.addReview(new Review("What a dumb course, you are an Idiot!"));
			
			
			// save the course and reviews
			session.save(course);
			
			
			
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
