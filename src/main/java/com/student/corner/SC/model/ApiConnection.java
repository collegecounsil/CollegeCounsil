package com.student.corner.SC.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.student.corner.SC.util.Constants.ApiConnectionStatus;
import com.student.corner.SC.util.Constants.ApiProvider;

@Entity
@Table(name="apiConnection")
public class ApiConnection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "api_id")
	private Long id;
	
	//Contains API Provider
	@NotNull
	@Column(length = 255, nullable = false)
	@Enumerated(EnumType.STRING)
	private ApiProvider provider;
	
	//Decides weather API is enabled by User or not
	private boolean enabled = false;
	
	//Contains AccessToken of an API for the user 
	@Lob
	@Column(nullable = true)
	private String accessToken;
	
	//Contains API Connection Status
	@NotNull
	@Column(length = 255, nullable = false)
	@Enumerated(EnumType.STRING)
	private ApiConnectionStatus connectionStatus;
	
	//ApiConnection of a User
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ApiProvider getProvider() {
		return provider;
	}

	public void setProvider(ApiProvider provider) {
		this.provider = provider;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public ApiConnectionStatus getConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(ApiConnectionStatus connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
