package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		
		// create Session factory
 
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		// create Session
		
		Session session = factory.getCurrentSession();
		
		
		
		try {
			
					
			// Start a transaction
			session.beginTransaction();
		
			// query Students
			List<Student> students = session.createQuery("from Student").getResultList();
			
			displayStudents(students);

			
			// query students : last name = Doe
			students = session.createQuery("from Student s where s.lastName = 'DOe'").getResultList();
			
			
			// display Result
			System.out.println("\n\nSearch for 1 Student");
			displayStudents(students);
			
			
			//query Students with lastName Doe or Duffy
			
			students = session.createQuery("from Student s where s.lastName ='DOe' OR s.lastName = 'Duck'").getResultList();
			
			
			// display Result
			System.out.println("\n\nSearch for 1 or more Student");
			displayStudents(students);
			
			
			// query with like on email adress
			
			students = session.createQuery("from Student s where s.email like '%gmx.com'").getResultList();
			
			// display Result
			System.out.println("\n\nSearch for mail adresse with Like");
			displayStudents(students);
			
			
			
			// commit transaction
			
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {

			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> students) {
		// display the students
		for (Student currentStudent : students) {
			
			System.out.println(currentStudent);
		}
	}

}
