package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect  {
	
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",throwing="theException")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theException ) {
		
		//print out which method we are advising on 
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Exetuing @AfterThrowing on the method : " +method);
		
		
		// log the exception
		System.out.println("=====> Throwing  : "+ theException);
		
	}

	// this is where we add all of our related advices for logging
    @Before("com.luv2code.aopdemo.aspect.LuvAopDeclarations.forDAOPackageNoGettesAndSetters()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
		System.out.println("\n =====>> Executing @Before advice on addAccount()");

		// display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println(methodSignature.toString());
		
		// display method arguments
		
		Object objectList[] = theJoinPoint.getArgs();
		
		for (Object object : objectList) {
			
			System.out.println(object);
			
			if (object instanceof Account) {
				
				Account theAccount = (Account) object;
				
				System.out.println("Name  : " + theAccount.getName());
				System.out.println("Level : " + theAccount.getLevel());
				
			}
			
		}
		
	}
    
    
    // add a new advice for @AfterReturning on the findAccounts method
    
    @AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",returning="result")
    public void afterReturningFindAccountAdvice(JoinPoint theJointPoint, List<Account> result) {
    	
    	// print out the results of the method call
    	String method = theJointPoint.getSignature().toShortString();
    	System.out.println("\n=====>>> Exetuing @AfterReturning on the method : " +method);

    	
    	System.out.println("\n=====>>> result is : " + result);
    	
    // lets post-process the data  !!
    	
    	
    	// convert the account names to uppercase
    	
    	convertAccountNamesToUpperCase(result);
    	
    }


	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account account : result) {
			
			account.setName(account.getName().toUpperCase());
		}
		
		
	}
    
    
    
    

}
