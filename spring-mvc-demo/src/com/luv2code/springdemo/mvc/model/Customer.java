package com.luv2code.springdemo.mvc.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springdemo.mvc.validation.CourseCode;

public class Customer {
	
	@NotNull(message="Null not allowed is required")
	@Size(min=1,message="is required")
	private String firstName;
	
	@NotNull(message="Null not allowed is required")
	@Size(min=1,message="is required")
	private String lastName;
	
	@NotNull(message="This Field is required")
	@Min(value=0 , message="Muss grösser or gleich 0 sein.")
	@Max(value=10 , message="Darf nicht grösser or gleich 10 sein.")
	private Integer freePasses;
	
    @Pattern(regexp="^[a-zA-Z0-9]{5}",message="nur 5 Zahlen oder Buchstaben erlaubt !")	
	private String postalCode;
	
    @CourseCode(value="Alex",message="First Letters have to bee LUV")
    private String courseCode;
    
    
	
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
	public Integer getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", freePasses=" + freePasses + "]";
	}

}
