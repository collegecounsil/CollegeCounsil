package com.student.corner.SC.bean;

import java.util.Map;

public class CommonBO {
	
	private String status;
	private String message;
	//Contains all the errors, if any
	private Map<String, String> errors;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

}
