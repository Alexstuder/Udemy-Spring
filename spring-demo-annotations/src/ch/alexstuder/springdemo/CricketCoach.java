package ch.alexstuder.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

private FortuneService happyFortune;

	@Autowired
	public CricketCoach(@Qualifier("dataBaseFortuneService") FortuneService happyFortune) {
		super();
		this.happyFortune = happyFortune;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Do some Ball exercises !";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return happyFortune.getFortune();
	}

}
