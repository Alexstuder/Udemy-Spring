package com.luv2code.aopdemo.aspect;

import java.security.Timestamp;
import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	
	Logger myLogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object araoundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//print out which method we are advising on 
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @Around on the method : " + method);
		
		long start = System.currentTimeMillis();
		
		Object result = joinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		long duration = end - start ;
		myLogger.info("\n=====> Duration: " + duration / 1000.0 + "seconds");
		
		return result;
	}
	
	
	
 	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		//print out which method we are advising on 
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Exetuing @AfterFinally on the method : " +method);

		
		
		
		
	}
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",throwing="theException")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theException ) {
		
		//print out which method we are advising on 
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Exetuing @AfterThrowing on the method : " +method);
		
		
		// log the exception
		myLogger.info("=====> Throwing  : "+ theException);
		
	}

	// this is where we add all of our related advices for logging
    @Before("com.luv2code.aopdemo.aspect.LuvAopDeclarations.forDAOPackageNoGettesAndSetters()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
		myLogger.info("\n =====>> Executing @Before advice on addAccount()");

		// display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info(methodSignature.toString());
		
		// display method arguments
		
		Object objectList[] = theJoinPoint.getArgs();
		
		for (Object object : objectList) {
			
			myLogger.info(object.toString());
			
			if (object instanceof Account) {
				
				Account theAccount = (Account) object;
				
				myLogger.info("Name  : " + theAccount.getName());
				myLogger.info("Level : " + theAccount.getLevel());
				
			}
			
		}
		
	}
    
    
    // add a new advice for @AfterReturning on the findAccounts method
    
    @AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",returning="result")
    public void afterReturningFindAccountAdvice(JoinPoint theJointPoint, List<Account> result) {
    	
    	// print out the results of the method call
    	String method = theJointPoint.getSignature().toShortString();
    	myLogger.info("\n=====>>> Exetuing @AfterReturning on the method : " +method);

    	
    	myLogger.info("\n=====>>> result is : " + result);
    	
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
