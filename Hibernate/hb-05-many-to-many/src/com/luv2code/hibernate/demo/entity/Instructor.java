package com.luv2code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// define class as Entity
@Entity
@Table(name="instructor")
public class Instructor {
	
	
	// Define the fields as DB fields

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	
	@OneToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;
	
	
	@OneToMany(mappedBy="instructor",cascade= {CascadeType.DETACH, CascadeType.MERGE,
			                                   CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Course> course;


	//get a constructor
	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	//get a constructor
	public Instructor(String firstName, String lastName, String email, InstructorDetail instructorDetail) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.instructorDetail = instructorDetail;
	}
	public Instructor() {
	}
	
	
	
	
	// get getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}
	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	
	
	
	public void add(Course course) {
		
		if (this.course == null) {
        this.course = new ArrayList<>();
		}
		
		this.course.add(course);
		course.setInstructor(this);
		
		
		
	}
	// get a toString method
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}
	
	
	
	
	

}
