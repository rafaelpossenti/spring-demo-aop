package com.possenti.aopdemo.dao;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.possenti.aopdemo.Account;
import com.possenti.aopdemo.DemoConfig;

public class AfterReturningDemoApp {
	
	public static void main(String[] args) {
		
		//read spring config java class 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container 
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//call method to find the accounts
		List<Account> accounts = accountDAO.findAccounts();
		
		System.out.println("\nMain Program: AfterReturningDemoApp");
		System.out.println("------");
		
		System.out.println(accounts);
		
		System.out.println();
		
		//close the context
		context.close();
	}

}
