package com.student.corner.SC.bean;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


public class UserBean {
	
	// Contains first name of the user
	@Size(max = 100)
	private String firstName;

	// Contains last name of the user
	@Size(max = 100)
	private String lastName;

	// Contains email address of the user
	@Size(max = 255)
	@Email
	private String email;

	// Stores the phone number of the user
	@Size(max = 50)
	private String phone;
	
	//Contains password for the user to login
	@Size(max = 1024)
	private String password;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
