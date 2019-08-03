package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	
	
	// let's start with an @Before advice
	
	// Calls every Method with the Name addAccount()
    //@Before("execution(public void addAccount())")
	
	// Calls the specific Method out of the specific Class : full qualified Name
    //@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	
	// Calls every Method begining with add*
    //@Before("execution(public void add*())")

	//Calls every Method no matter the returnType
    //@Before("execution(* add*())")
   	
	//Calls every Method in the given package name with any parameter
    //@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")

	//Calls a Method with one Parameter ; needs to be full qualified
    //@Before("execution(* add*(com.luv2code.aopdemo.Account))")

	//Calls any Method in the package with any returnType and any Parameter
    @Before("execution(* com.luv2code.aopdemo.*.*.*(..))")
	public void beforeAddAccountAdvice(){
		System.out.println("\n =====>> Executing @Before advice on addAccount()");
	
	}
	
	// let's get further with an @After advice
//	@After("execution(public void addAccount())")
//	public void afterAddAccountAdvice(){
//		System.out.println("\n =====>> Executing @After advice on addAccount()");
//		
//	}
	
	
}
