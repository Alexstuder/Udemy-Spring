package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TraficFortuneService;

public class AroundWithLoggerDemoApp {
	
	
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from the spring container
		TraficFortuneService fortuneService = context.getBean("traficFortuneService", TraficFortuneService.class);

		myLogger.info("\n Main Program : AroundDemoApp");
		
		String data = fortuneService.getFortune();
		
		myLogger.info("\nMy Fortune ist :" + data);
		myLogger.info("\nFinished");
		

		// close the context
		context.close();

	}

}
