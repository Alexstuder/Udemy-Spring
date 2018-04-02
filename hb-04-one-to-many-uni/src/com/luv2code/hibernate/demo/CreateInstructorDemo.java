package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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

			
            // get the instructor from db
			int id = 1;
			Instructor tempInstructor = session.get(Instructor.class, id );
			
			// create some courses
            Course course1 = new Course("Unity", tempInstructor);
            Course course2 = new Course("Blender", tempInstructor);
            Course course3 = new Course("Maya", tempInstructor);
			
			
			//add courses to instructo
			tempInstructor.getCourse().add(course1);
			tempInstructor.getCourse().add(course2);
			tempInstructor.getCourse().add(course3);
			
			//save the courses
			session.save(course2);
			session.save(course3);
			
		
			
			
			
			
			
			
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
