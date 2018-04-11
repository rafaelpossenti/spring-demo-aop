package com.possenti.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.possenti.aopdemo.Account;

@Component
public class MemberShipDAO {
	
	public void addAccount() {
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
	}
	
	public void addUser(Account account) {
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP User");
	}
}
