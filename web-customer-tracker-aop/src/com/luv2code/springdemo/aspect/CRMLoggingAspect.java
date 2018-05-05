package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName()) ;
	
	// setup pointcut declarations
	
	@Pointcut("execution(* com.luv2code.springdemo..controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	
	
	// add@Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method we are calling
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====> in @Before: calling method: " + method);
		
		
//		// display the arguemnts to the method
		
		// get ARguments ; loop trough and display args
		for (Object args : theJoinPoint.getArgs()) {
			myLogger.info("======> Args : "+ args);
			
		}
		
	}
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="result")
	public void afterReturning(JoinPoint theJoinPoint, Object result) {
		
		
		// displaay method we are returning from
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>>>>>> in @AfterReturning: calling method: " + method);
		
		
		//display data returned
		myLogger.info("=====>>>>>> in @AfterReturning: " + result);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
