package ch.alexstuder.myjavaspringconfigpractice;

public class FortuneService implements Fortune {

	@Override
	public String getDailyFortune() {
		return "Special Fortune for my JavaConfig Practice Work";
	}

}
