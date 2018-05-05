package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	
	private String serviceCode;
	
	
	
	public List<Account> findAccounts(boolean tripWire){
		
		List<Account> accounts = new ArrayList<Account>();
		
		// create some accounts
		Account temp1 = new Account("John", "Gold");
		Account temp2 = new Account("Karl", "Silver");
		Account temp3 = new Account("Luca", "Platin");
		
		accounts.add(temp1);
		accounts.add(temp2);
		accounts.add(temp3);
		
		
		if (tripWire) {
			throw new RuntimeException("This is a TripWire Exception");
			
		}
		
		return accounts;
	}
	
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
