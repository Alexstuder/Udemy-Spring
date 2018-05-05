package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TraficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from the spring container
		TraficFortuneService fortuneService = context.getBean("traficFortuneService", TraficFortuneService.class);

		System.out.println("\n Main Program : AroundDemoApp");
		
		String data = fortuneService.getFortune();
		
		System.out.println("\nMy Fortune ist :" + data);
		System.out.println("\nFinished");
		

		// close the context
		context.close();

	}

}
