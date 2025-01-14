package com.luv2code.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table(name="course")
public class Course {

	
	//define fields
	
	//define constructor
	
	//getter and setter
	
	
	//toSTring
	
	
	//annotate Fields
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	


	@Column(name="title")
	private String title;
	
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			             CascadeType.REFRESH, CascadeType.DETACH })
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	
	public Course() {
		
		
	}
	
	
	public Course(String title, Instructor instructor) {
		super();
		this.title = title;
		this.instructor = instructor;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Instructor getInstructor() {
		return instructor;
	}


	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	
	
	
	
	
}
