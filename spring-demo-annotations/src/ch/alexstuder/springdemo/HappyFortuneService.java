package ch.alexstuder.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Smile every Day and you will be happy !";
	}

}
