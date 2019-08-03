package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		// get the bean from the spring container
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		Account account = new Account();
		
		// Call the getters and setters
        accountDAO.setName("foobar");
        accountDAO.getName();
        accountDAO.setServiceCode("silver");
        accountDAO.getServiceCode();
		
		
        accountDAO.addAccount(account,true);
        // call the business method
        accountDAO.doWork(account);

        // call teh membershipDAO business method
        membershipDAO.addSilyMember();

        // call teh membershipDAO business method
        membershipDAO.gotoSleep();;
        
        // call the business method again
        System.out.println("\n#######################   let's call the Method again    ##########################");
        accountDAO.addAccount(account,true);
		
        
        
        
        
		// close the context
		context.close();
		
	}

}
