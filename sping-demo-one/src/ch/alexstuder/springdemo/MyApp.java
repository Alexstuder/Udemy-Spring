package ch.alexstuder.springdemo;

public class MyApp {

	public static void main(String[] args) {

		// create the Object
		Coach theCoach = new TrackCoach();
		
		//use the object
		
		System.out.println(theCoach.getDailyWorkout());
		
	}

}
