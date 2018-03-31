package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		
		// create Session factory
 
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		// create Session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// use the session to save  Java Objects
			
			// Start a transaction
			session.beginTransaction();

//			int id = 8 ;
//			Student mystudent = session.get(Student.class, id);
//			
//			// delete the student
//			System.out.println("Delete myStudent :" + mystudent);
//			session.delete(mystudent);
			
			
			// delete Student 
			session.createQuery("delete from Student s where s.firstName ='Paul'").executeUpdate();
			
			
            // Commit the Transaction			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {

			factory.close();
		}
		
	}

}
