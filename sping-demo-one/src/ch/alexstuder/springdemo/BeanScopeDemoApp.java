package ch.alexstuder.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context =
				
				new ClassPathXmlApplicationContext("beanscope-applicationContext.xml");
		
		
		// retrieve bean from Container
		
		
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		Coach theCoach   = context.getBean("myCoach",Coach.class);
		
		// check if the are the same
		
		boolean result = (theCoach == alphaCoach);
		
		
		// print out the result
		System.out.println("\nPointing to the same object :" + result);
		System.out.println("\nMemory Location for theCoach  :" + theCoach);
		System.out.println("Memory Location for alphaCoach:" + alphaCoach);
		// close the context
		
	   context.close();
		
		
		
		
	}

}
