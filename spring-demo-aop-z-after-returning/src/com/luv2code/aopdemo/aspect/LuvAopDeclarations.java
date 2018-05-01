package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopDeclarations {

	// declare a pointcut for all methods in package
		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
		public void forDAOPackage() {}
		
		
		// declare a pointcut for all setter in package
		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
		public void forDAOPackageGetters() {}
		
		// declare a pointcut for all getter in package
		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
		public void forDAOPackageSetters() {}
		
		// declare a pointcut include package  and exclude getters and settersfor all getter in package
		@Pointcut("forDAOPackage() && !(forDAOPackageSetters() || forDAOPackageGetters())")
		public void forDAOPackageNoGettesAndSetters() {}
	
}
