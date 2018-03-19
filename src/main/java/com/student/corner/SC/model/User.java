package com.student.corner.SC.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="user_info")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	

	//Contains password for the user to login
	@Column(name = "password")
	@NotNull
	@NotBlank
	private String password;
	
	//Contains first name of the user 
	@Column(name = "first_name")
	private String firstName;

	//Contains last name of the user
	@Column(name = "last_name")
	private String lastName;
	
	//Contains email address of the user
	@Email
	@Column(unique = true,name = "email")
	private String email;
	
	//Stores the phone number of the user
  	@Column(unique = true,name= "phone")
	private String phone;
	
	//Contains unique Key for a User. Used in Job Seeker to Open Job Seeker Profile with direct link of URL
	@Column(unique = true,length = 1024, nullable = true)
	private String userKey;
	
	//Contains when user last Logged-in to the application. Updated when user logs in.
	@Column(name= "last_login",nullable = true)
	private Date lastLogin;
	
	//Contains when user last Password Reset to the application. Updated when user logs in.
	@Column(name= "last_Password_Reset",nullable = false)
	private Date lastPasswordResetDate;
	
	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}


	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}


	//Represents weather user is enabled or not
	@Column(name = "active")
	private boolean active;
	
	//Represents weather user account is not expired
	private boolean accountNonExpired = true;
	
	
	//Represents weather user account is not locked
	private boolean accountNonLocked = true;
	
	//User can have multiple Roles
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles;
	
	
	//User a.k.a Job Seekers has many API Connections
	@OneToMany(mappedBy = "user")
	private List<ApiConnection> apiConnections;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getUserKey() {
		return userKey;
	}


	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}


	public Date getLastLogin() {
		return lastLogin;
	}


	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}


	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}


	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}


	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}


	public List<ApiConnection> getApiConnections() {
		return apiConnections;
	}


	public void setApiConnections(List<ApiConnection> apiConnections) {
		this.apiConnections = apiConnections;
	}


	public Collection<Role> getRoles() {
		return roles;
	}


	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

}