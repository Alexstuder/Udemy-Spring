package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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

			
			// get a student from DB

			int id = 1;
			
			Student myStudent = session.get(Student.class, id);
			System.out.println("myStudent  :" + myStudent);
			
			// Update a field
			myStudent.setEmail("alex@gmail.com");
			System.out.println("Update the Object " + myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");

			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Update all email");
			
			session.createQuery("update Student set email = 'foo@mail.com'").executeUpdate();
			
			session.getTransaction().commit();

			
			// Bulk Update with List
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// get a List of Students with where email  like %foo%

			List<Student> students = session.createQuery("from Student s where s.email like '%foo%'").getResultList();
			
			for (Student currentStudent : students) {
				
				currentStudent.setEmail("electorn@protonmail.com");
				
				
			}
			
			
			// iterate and set the email to gmail
			
			
			session.getTransaction().commit();
			
		} finally {

			factory.close();
		}
		
	}

}
