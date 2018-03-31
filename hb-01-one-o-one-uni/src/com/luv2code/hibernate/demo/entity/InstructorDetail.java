package com.luv2code.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//annotate the class as an entity and map to db
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
	// define fields
	// annotate the fields with db columns names
    @Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

    @Column(name="youtube_channel")
	private String youtubechannels;

    @Column(name="hobby")
	private String hobby;

    // create constructors
	public InstructorDetail(String youtubechannels, String hobby) {
		this.youtubechannels = youtubechannels;
		this.hobby = hobby;
	}

	// create constructors
	public InstructorDetail() {
	}

	// generate getter and setters methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubechannels() {
		return youtubechannels;
	}

	public void setYoutubechannels(String youtubechannels) {
		this.youtubechannels = youtubechannels;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	// generate tostring methode
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubechannels=" + youtubechannels + ", hobby=" + hobby + "]";
	}


	


}
