package com.example.demo.models;

public class SignupResponse {

	private int     errorCode;
	private String  errorMsg;
	private String  loginToken;
	
	public SignupResponse() {}

	public SignupResponse(String loginToken, int errorCode, String errorMsg) {
		super();
		this.loginToken = loginToken;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}


	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getLoginToken() {
		return loginToken;
	}

	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
	}

}
