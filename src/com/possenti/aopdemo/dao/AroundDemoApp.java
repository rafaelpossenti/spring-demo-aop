package com.possenti.aopdemo.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.possenti.aopdemo.DemoConfig;
import com.possenti.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {
	
	public static void main(String[] args) {
		
		//read spring config java class 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container 
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("\nMain program: ArroundDemoApp");
		System.out.println("calling getFortune()");
		
		String data = fortuneService.getFortune();
		
		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");
		//close the context
		context.close();
	}

}
