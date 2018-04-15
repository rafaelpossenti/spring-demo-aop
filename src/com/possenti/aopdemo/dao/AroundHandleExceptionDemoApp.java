package com.possenti.aopdemo.dao;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.possenti.aopdemo.DemoConfig;
import com.possenti.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		//read spring config java class 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container 
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		logger.info("\nMain program: ArroundDemoApp");
		logger.info("calling getFortune()");
		
		String data = fortuneService.getFortune();
		
		logger.info("\nMy fortune is: " + data);
		logger.info("Finished");
		//close the context
		context.close();
	}

}
