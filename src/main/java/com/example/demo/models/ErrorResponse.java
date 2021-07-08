package com.example.demo.models;

public class ErrorResponse {
	private int severity;
	private String message;
	
	public ErrorResponse() {}

	public ErrorResponse(int severity, String message) {
		super();
		this.severity = severity;
		this.message = message;
	}

	public int getSeverity() {
		return severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

	
}
