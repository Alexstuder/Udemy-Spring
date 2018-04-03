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

public class CreateCourseAndStudentsDemo {

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
			
			
	        // create a course
			
			Course course = new Course("Pacman - How to score Million Points");
			
			// save the course
			System.out.println("\nSaving the Course: "+ course);
			session.save(course);
			
			// create the students
			Student student1 = new Student("John","Doe","john@gmx.com");
			Student student2 = new Student("Mary","Public","john@gmx.com");
			
			// add students to the course

			course.addStudents(student1);
			course.addStudents(student2);
			
			//save the students
			System.out.println("Saving the students");
			session.save(student1);
			session.save(student2);
			
			System.out.println("Students saved : " + course.getStudents());
			
			
			
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
