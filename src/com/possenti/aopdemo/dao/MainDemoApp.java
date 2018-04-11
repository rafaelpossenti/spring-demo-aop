package com.possenti.aopdemo.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.possenti.aopdemo.Account;
import com.possenti.aopdemo.DemoConfig;

public class MainDemoApp {
	
	public static void main(String[] args) {
		
		//read spring config java class 
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container 
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		MemberShipDAO memberShipDAO = context.getBean("memberShipDAO",MemberShipDAO.class);
		
		Account account = new Account();
		
		
		//call the business method
		accountDAO.addAccount(account, true);
		memberShipDAO.addAccount();
		memberShipDAO.addUser(account);
		
		//close the context
		context.close();
	}

}
