package com.possenti.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.possenti.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name; 
	private String serviceCode;
	
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
