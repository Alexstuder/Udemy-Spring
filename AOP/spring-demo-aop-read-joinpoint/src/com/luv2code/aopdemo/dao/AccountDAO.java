package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	
	private String serviceCode;
	
	
	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + ": Doing my db Work : Adding an Account");
		
	}

	public void doWork(Account account) {
		
		System.out.println(getClass() + ": Doing my db Work : do Work");
		
	}

	public String getName() {
		System.out.println(getClass() + ": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
}
