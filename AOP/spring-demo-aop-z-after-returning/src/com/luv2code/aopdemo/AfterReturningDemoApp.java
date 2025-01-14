package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the bean from the spring container
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);

		List<Account> accounts = accountDAO.findAccounts();
		
		System.out.println("\n\n Main Program : AfterReturningDemoApp");
		System.out.println("----");
		System.out.println(accounts);
		System.out.println("\n");
		
		
		
		
		
		
		
		
		// close the context
		context.close();
		
	}

}
