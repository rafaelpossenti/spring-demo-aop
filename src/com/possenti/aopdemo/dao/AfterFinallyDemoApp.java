package com.possenti.aopdemo.dao;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.possenti.aopdemo.Account;
import com.possenti.aopdemo.DemoConfig;

public class AfterFinallyDemoApp {
	
	public static void main(String[] args) {
		
		//read spring config java class 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container 
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//call method to find the accounts
		List<Account> accounts = null; 
		
		try {
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		}catch(Exception exc) {
			System.out.println("\n\nMain Program ...  caught exception: " + exc);
		}
		
		System.out.println("\nMain Program: AfterThrowingDemoApp");
		System.out.println("------");
		
		System.out.println(accounts);
		
		System.out.println();
		
		//close the context
		context.close();
	}

}
