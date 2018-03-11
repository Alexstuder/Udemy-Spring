package ch.alexstuder.springdemo;

public class BaseballCoach implements Coach {
	
	//define a private filed for the dependency
	private FortuneService fortuneService ;
	
	
	// define a constructor for dependency Injection
	public BaseballCoach(FortuneService theFortuneService) {
     fortuneService = theFortuneService ;
	}
	
	@Override
	public String getDailyWorkout() {
		
		
		return "Spend 30 min on batting practice";
	}

	@Override
	public String getDailyFortune() {
	   // use my fortuneService to get a fortune
		
		return fortuneService.getFortune();
	}

}
