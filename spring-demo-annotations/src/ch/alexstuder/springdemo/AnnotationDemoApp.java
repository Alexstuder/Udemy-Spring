package ch.alexstuder.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// read Spring configFile
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		
		
		
		
		// get the bean from the spring container
		Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		
		// call a method on the bean
		System.out.println( theCoach.getDailyWorkout());
		System.out.println( theCoach.getDailyFortune());
		
		
		// get Cricket Coach with default BeanID
		Coach cricketCoach = context.getBean("cricketCoach",Coach.class);
		
		// call amethod
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());
		
		
		
		// get a ChessCoach
		
		Coach chesscoach = context.getBean("SchachTrainer",Coach.class);
		
		
		// call the method 
		
		System.out.println(chesscoach.getDailyWorkout());
		System.out.println(chesscoach.getDailyFortune());
		
		
		// get a PingPon Coach 
		Coach pingPongCoach = context.getBean("pingPongCoach",Coach.class);
		
		// call a Frotune Service from File
		
		System.out.println(pingPongCoach.getDailyWorkout());
		System.out.println(pingPongCoach.getDailyFortune());
		
		// close the container
		context.close();

	}

}
