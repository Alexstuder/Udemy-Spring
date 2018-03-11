package ch.alexstuder.springdemo;

public class HandballCoach implements Coach {

	private FortuneService fortuneService;
	
	
	public HandballCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Do some ball training";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do It :"+fortuneService.getFortune();
	}

}
