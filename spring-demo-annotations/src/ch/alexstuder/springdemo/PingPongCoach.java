package ch.alexstuder.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PingPongCoach implements Coach {

	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortune ;
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Do your Volley exercises !";
	}

	@Override
	public String getDailyFortune() {
		return fortune.getFortune();
	}

}
