package ch.alexstuder.springdemo;

public class CricketCoach implements Coach {

	private String emailAddress;
	private String team;
	private FortuneService fortuneService;
	
	
	//create a non-arg Constructor
	public CricketCoach() {
    System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 min !";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	// our setter method , called by Spring
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter Method - setFortune");
		this.fortuneService = fortuneService;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter Method - setEmailAdress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter Method - setTeam");
		this.team = team;
	}
	
	

}
