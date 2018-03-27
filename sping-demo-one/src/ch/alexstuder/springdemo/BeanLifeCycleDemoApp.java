package ch.alexstuder.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context =
				
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		
		// retrieve bean from Container
		
		
		Coach theCoach   = context.getBean("myCoach",Coach.class);
		
		// check if the are the same
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		
	   context.close();
		
		
		
		
	}

}
