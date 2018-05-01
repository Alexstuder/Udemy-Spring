package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging

	// declare a pointcut for all methods in package
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	
	// declare a pointcut for all setter in package
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void forDAOPackageGetters() {}
	
	// declare a pointcut for all getter in package
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void forDAOPackageSetters() {}
	
	// declare a pointcut include package  and exclude getters and settersfor all getter in package
	@Pointcut("forDAOPackage() && !(forDAOPackageSetters() || forDAOPackageGetters())")
	private void forDAOPackageNoGettesAndSetters() {}
	
	
    @Before("forDAOPackageNoGettesAndSetters()")
	public void beforeAddAccountAdvice(){
		System.out.println("\n =====>> Executing @Before advice on addAccount()");
	
	}

    @Before("forDAOPackageNoGettesAndSetters()")
    public void performApiAnalytics(){
    	System.out.println("\n =====>> Performing API Anlytics");
    	
    }
	
}
