package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			
			
			int id = 1;

			Query<Instructor> query =
					session.createQuery("select i from Instructor i JOIN FETCH i.course"
							+ " where i.id=:theInstructorId",Instructor.class);
			query.setParameter("theInstructorId", id);
			
			
			// execute and get the Instructor
			
			Instructor instructor = query.getSingleResult();
			
			System.out.println("Mein Code : Instructor :" + instructor);
			
			//commit the transaction
			session.getTransaction().commit();
			
			session.close(); 
			System.out.println("Session is Closed");
			System.out.println("Mein Code : Courses :" + instructor.getCourse());
			
			
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
