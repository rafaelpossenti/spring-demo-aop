package com.possenti.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.possenti.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name; 
	private String serviceCode;
	
	public List<Account> findAccounts(boolean tripWire){
		
		if(tripWire) {
			throw new RuntimeException("No soup for you!!!");
		}
		
		
		List<Account> accounts = new ArrayList<>();
		
		Account account1 = new Account("John","Silver");
		Account account2 = new Account("Madhu","Platinum");
		Account account3 = new Account("Luca","Gold");
		
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		
		return accounts;
	}
	
	public void addAccount(Account account, boolean vip	) {
		System.out.println(getClass() + "DOING MY DB WORK: ADDING AN ACCOUNT" );
	}

	public String getName() {
		System.out.println(getClass() +  ": in getName()" );	
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println(getClass() +  ": in setName()" );
	}

	public String getServiceCode() {
		System.out.println(getClass() +  ": in getServiceCode()" );
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() +  ": in setServiceCode()" );
		this.serviceCode = serviceCode;
	}
	
}
