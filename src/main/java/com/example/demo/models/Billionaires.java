package com.example.demo.models;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity
@Table
public class Billionaires {
	@Id	@Column private int id;
	private String first_name;
	private String last_name; 
	private String career;

	public Billionaires() {}

	public Billionaires(int id, String first_name, String last_name, String career) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.career = career;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}	
}
