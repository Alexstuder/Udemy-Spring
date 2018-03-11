package ch.alexstuder.springdemo;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class HappFortuneService implements FortuneService {
	
	
	
	private ArrayList<String> fortunes = new ArrayList();
	
	
	public HappFortuneService() {
		
		this.fortunes.add("Today is your lucky Day");
		this.fortunes.add("Every Day is a happy Day");
		this.fortunes.add("Pets makes you Happy");
		this.fortunes.add("Make some sport to recieve happines");
		this.fortunes.add("Make somebody smile to get some happines");
	}
	

	@Override
	public String getFortune() {
		int randamNummber = ThreadLocalRandom.current().nextInt(0,this.getFortunes().size());
		
		
		return getFortunes().get(randamNummber);
	}


	public ArrayList<String> getFortunes() {
		return fortunes;
	}


	public void setFortunes(ArrayList<String> fortunes) {
		this.fortunes = fortunes;
	}

}
