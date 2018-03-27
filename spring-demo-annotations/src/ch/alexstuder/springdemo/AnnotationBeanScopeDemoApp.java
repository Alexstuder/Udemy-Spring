package ch.alexstuder.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		
		// load SpringConfig File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		
		// retrieve Bean from Spring Container
		Coach theTennisCoach = context.getBean("thatSillyCoach", Coach.class);
		
		Coach theAlphaCoach = context.getBean("thatSillyCoach", Coach.class);
				
		boolean result = (theTennisCoach == theAlphaCoach);
		
		
		System.out.println("\nPointing to the same object :" + result);
		
		System.out.println("\nMemory for theCoach" + theTennisCoach);
		System.out.println("\nMemory for theAlphaCoach" + theAlphaCoach);
		
		//close the Context
		context.close();
		
		
	}

}
