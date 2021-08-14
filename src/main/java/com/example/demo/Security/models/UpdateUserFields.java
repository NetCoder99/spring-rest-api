package com.example.demo.Security.models;


public class UpdateUserFields {
	private int userId;
	//private String userName;
	private String passWord;
	private String firstName;
	private String lastName;

	public UpdateUserFields() { }

	public UpdateUserFields(int userId, String passWord, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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

}
