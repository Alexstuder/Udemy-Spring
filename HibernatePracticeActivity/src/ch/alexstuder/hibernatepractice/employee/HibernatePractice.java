package ch.alexstuder.hibernatepractice.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;

import ch.alexstuder.hibernatepractice.employee.model.Employee;

public class HibernatePractice {

	public static void main(String[] args) {

		// Get a Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// Get a Session and begin
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		// Save object
		Employee employee1 = new Employee("Kurst", "Wenger", "ZKB");
		session.save(employee1);
		Employee employee2 = new Employee("Karin", "Mueller", "Credit Suisse");
		session.save(employee2);
		Employee employee3 = new Employee("Peter", "Gehrig", "ZKB");
		session.save(employee3);
		Employee employee4 = new Employee("Felix", "Streuli", "UBS");
		session.save(employee4);
		Employee employee5 = new Employee("Bonita", "Dampf", "ZKB");
		session.save(employee5);

		session.save(employee1);
        session.getTransaction().commit();		
		
		// Retrieve an object by primary key
        // Get a Session and begin
//        session = factory.getCurrentSession();
//        session.beginTransaction();
//
//        
//        
//        
//        session.getTransaction().commit();		
        
		// query object to find an employye for a given company

		// delete an object by primary key

		
		
		//close facory
		factory.close();
		System.out.println("Done!");
		
	}

}
