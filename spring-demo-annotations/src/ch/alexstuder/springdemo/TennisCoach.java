package ch.alexstuder.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
//@Scope("prototype")
@Scope("singleton")
public class TennisCoach implements Coach {

	private FortuneService happyFortune;
	
	
	@Value("${tennis.email}")
	private String eMail;
	
	@Value("${tennis.team}")
	private String team;

	// public default constructor
	public TennisCoach() {
		System.out.println("TennisCoach==>Inside default Constructor");
	}

	// define a setter Method
	@Autowired
	@Qualifier("randomFortuneService")
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println("TennisCoach==>Inside Autowired Tennis doSomeCrazyStuff()");
		System.out.println("TennisCoach eMailAdress :" + eMail);
		System.out.println("Team                    :" + team);
		this.happyFortune = fortuneService;
	}
	// define

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return happyFortune.getFortune();
	}
	
	
	@PostConstruct
	public void doPostConstructStuff() {
		System.out.println("TennisCoach==> Do some postConstruct Stuff");
	}

	@PreDestroy
	public void doSomePreDestroyStuff() {
		System.out.println("\nDo some preDestroyStuff");
	}
}