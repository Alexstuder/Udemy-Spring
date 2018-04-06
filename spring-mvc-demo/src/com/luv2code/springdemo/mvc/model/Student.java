package com.luv2code.springdemo.mvc.model;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	
	private LinkedHashMap<String, String> countryOptions;

	private String favoriteLanguage;
	
	private String favoriteJunkFood;
	
	private LinkedHashMap<String, String> favoriteJunkFoodOptions;
	
	private String[] operatingSystems;

	
	
	public Student() {
		
		// populate country Options : used ISO Country code
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		countryOptions.put("CH", "Swiss");
		countryOptions.put("FR", "France");
		
		//populate favoriteJungFood
		
		favoriteJunkFoodOptions = new LinkedHashMap<>();
		favoriteJunkFoodOptions.put("MARS", "Mars");
		favoriteJunkFoodOptions.put("SNICKERS", "Snickers");
		favoriteJunkFoodOptions.put("TWIX", "Twix");
		favoriteJunkFoodOptions.put("BUTTERFINGER", "Butterfinger");
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}



	public String[] getOperatingSystems() {
		return operatingSystems;
	}



	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}



	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}



	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}



	public String getFavoriteJunkFood() {
		return favoriteJunkFood;
	}



	public void setFavoriteJunkFood(String favoriteJunkFood) {
		this.favoriteJunkFood = favoriteJunkFood;
	}



	public LinkedHashMap<String, String> getFavoriteJunkFoodOptions() {
		return favoriteJunkFoodOptions;
	}



	public void setFavoriteJunkFoodOptions(LinkedHashMap<String, String> favoriteJunkFoodOptions) {
		this.favoriteJunkFoodOptions = favoriteJunkFoodOptions;
	}



}


