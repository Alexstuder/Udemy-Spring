package ch.alexstuder.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("SchachTrainer")
public class ChessCoach implements Coach {

	@Autowired
	@Qualifier("RESTFortuneService")
	private FortuneService happyFortune;
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice some Chess Strategie";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return happyFortune.getFortune();
	}

}
