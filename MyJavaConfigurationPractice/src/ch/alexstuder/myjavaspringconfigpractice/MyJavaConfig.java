package ch.alexstuder.myjavaspringconfigpractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyJavaConfig {

	@Bean
	Fortune myFortuneService() {
		return new FortuneService();
	}
	
	@Bean
	Coach  myRollerbladeCoach() {
		return new RollerbladeCoach(myFortuneService());
	}
	
	
	
}
