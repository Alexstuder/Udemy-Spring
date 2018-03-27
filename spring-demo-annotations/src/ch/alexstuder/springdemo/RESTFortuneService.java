package ch.alexstuder.springdemo;

import org.springframework.stereotype.Component;

//@Component("rESTFortuneService")
@Component
public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "RestFortuneService";
	}

}
