package ch.alexstuder.myjavaspringconfigpractice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyJavaConfigApp {

	public static void main(String[] args) {

		// define Context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyJavaConfig.class);
		
		
		// get the Bean
		
		Coach theCoach = context.getBean("myRollerbladeCoach",Coach.class);
		
		
		// call Method from the Bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		
		//close Context
		
		context.close();
		
		
		
		
	}

}
