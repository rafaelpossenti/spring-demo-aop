package com.possenti.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDAO {
	
	public void addAccount() {
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
	}
}
