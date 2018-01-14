package com.student.corner.SC.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.student.corner.SC.util.Constants.RoleMaster;

/**
 * 
 * @author Raj
 * @since V1.0.0_14012017
 */

@Entity
@Table(name = "role")
public class Role {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="role_id")
	private int id;
	
	
	//Contains name of role
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private RoleMaster role;
	
	//Contains name of role
	@Column(nullable = true)
	String uiName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoleMaster getRole() {
		return role;
	}

	public void setRole(RoleMaster role) {
		this.role = role;
	}

	public String getUiName() {
		return uiName;
	}

	public void setUiName(String uiName) {
		this.uiName = uiName;
	}
		
		
}