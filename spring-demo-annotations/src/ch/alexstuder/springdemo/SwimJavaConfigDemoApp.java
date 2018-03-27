package ch.alexstuder.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		
		
		// read Spring configFile
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
			
		
//		// get the bean from the spring container
//		Coach theCoach = context.getBean("swimCoach", Coach.class);

		// ***************************************************
		// * Hier wird direkt SwimCoach aufgerufen , da diese Classe über eMail und Team verfügt 
		// * Dies ist lediglich als Beispiel für Field injection mit Properties File gedacht  
		// get the bean from the spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// call a method on the bean
		System.out.println( theCoach.getDailyWorkout());
		System.out.println( theCoach.getDailyFortune());
		
		//call our swim Coach methods .... has the props values injected
		
		System.out.println("eMail : " + theCoach.geteMail());
		System.out.println("Team  : " + theCoach.getTeam());
		
		// close the container
		context.close();

	}

}
