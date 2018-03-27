package ch.alexstuder.springdemo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	
	private String[] data = {
			"Beare of the wolf",
			"Eat well",
			"Carpe Diem",
			"Have Fun"
	};
	
	// create random number 
	
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		
		int index = random.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
