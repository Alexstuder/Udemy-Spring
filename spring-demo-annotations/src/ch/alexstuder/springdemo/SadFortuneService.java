package ch.alexstuder.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "sad fortunes here !! :-(";
	}

}
