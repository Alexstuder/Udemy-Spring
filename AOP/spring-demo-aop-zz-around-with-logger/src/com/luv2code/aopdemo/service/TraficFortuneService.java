package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TraficFortuneService {
	
	public String getFortune() {
		
		//simulate a delay
		
		// return a fortune
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return "Expect heavy traffic this morning" ;
		
		
		
	}
	

}
