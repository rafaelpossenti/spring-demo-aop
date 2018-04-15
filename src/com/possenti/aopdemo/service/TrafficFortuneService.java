package com.possenti.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		
		try {
			TimeUnit.SECONDS.sleep(5);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Expect havy traffic this morning";
	}
}

