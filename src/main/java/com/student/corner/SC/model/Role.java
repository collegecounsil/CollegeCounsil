package com.student.corner.SC.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.student.corner.SC.util.Constants.RoleMaster;

@Entity
@Table(name="role")
public class Role {
	
	//Contains DB ID
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Contains name of role
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = true)
	private RoleMaster name;
	
	//Contains name of role
	@Column(nullable = true)
	String uiName;
	
	//One User can have multiple roles
	@ManyToMany(mappedBy = "roles")
	List<User> users;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleMaster getName() {
		return name;
	}

	public void setName(RoleMaster name) {
		this.name = name;
	}
	
	public String getUiName() {
		return uiName;
	}

	public void setUiName(String uiName) {
		this.uiName = uiName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@Override
	public String toString() {
		return this.uiName;
	}
}
