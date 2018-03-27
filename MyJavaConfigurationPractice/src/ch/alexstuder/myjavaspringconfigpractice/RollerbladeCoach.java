package ch.alexstuder.myjavaspringconfigpractice;

public class RollerbladeCoach implements Coach {
	
	
	private Fortune fortune;
	

	public RollerbladeCoach(Fortune fortune) {
		super();
		this.fortune = fortune;
	}


	@Override
	public String getDailyWorkout() {
		return "Do a har 5k run todoay !";
	}


	@Override
	public String getDailyFortune() {
		return fortune.getDailyFortune();
	}
	
	
}
