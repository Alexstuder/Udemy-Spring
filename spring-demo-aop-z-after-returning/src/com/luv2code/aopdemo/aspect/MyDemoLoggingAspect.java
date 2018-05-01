package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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

}
