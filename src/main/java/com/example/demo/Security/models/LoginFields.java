package com.example.demo.Security.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class LoginFields {

	@Id	@Column @GeneratedValue(strategy=GenerationType.AUTO) private int userId;
	@Column(length = 15) private String userName;
	@Column(length = 50) private String passWord;
	
	public LoginFields() {
		super();
	}

	public LoginFields(int userId, String userName, String passWord) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}
