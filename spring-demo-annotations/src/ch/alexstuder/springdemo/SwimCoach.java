package ch.alexstuder.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	
	private FortuneService fortuneService ;
	
	
	@Value("${tennis.email}")
	private String eMail;
	
	
	@Value("${tennis.team}")
	private String team;

	public SwimCoach(FortuneService theFortuneService) {
		super();
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 2000 meters for warmup";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	public String geteMail() {
		return eMail;
	}

	public String getTeam() {
		return team;
	}


}
