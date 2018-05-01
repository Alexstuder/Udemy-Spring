package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the sessionFactory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomer() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

		// execute and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theCustomer);

		// save the customer
	}

	@Override
	public Customer getCustomer(int theId) {

		// get the current hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();

		// get the customer with the Id from the database
		Customer theCustomer = currentSession.get(Customer.class, theId);

		// return the customer

		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theID) {

		// get currentSession
		Session currentSession = sessionFactory.getCurrentSession();
		
		System.out.println("Delete : " + theID);
		
		// delete theCustomer using the ID
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theID);
		
		theQuery.executeUpdate();
		
	}

}
