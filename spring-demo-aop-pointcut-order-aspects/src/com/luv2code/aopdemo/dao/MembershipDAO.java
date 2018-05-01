package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addSilyMember() {
		
		System.out.println(getClass() + " : Doing some Stuff : adding a Membership Account");
		
		return false;
	}
	public void gotoSleep() {
		
		System.out.println(getClass() + " : Doin some Stuff : going to sleep");
		
	}
	
}
