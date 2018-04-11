package com.possenti.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.possenti.aopdemo.Account;

@Component
public class AccountDAO {
	public void addAccount(Account account, boolean vip) {
		System.out.println(getClass() + "DOING MY DB WORK: ADDING AN ACCOUNT" );
	}
}
