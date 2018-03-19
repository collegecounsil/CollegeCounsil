package com.student.corner.SC.service;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable {

	private static final long serialVersionUID = 1250166508152483573L;

	private final String token;
    private int expires_in;
    
	public JwtAuthenticationResponse(String token, int expires_in) {
		super();
		this.token = token;
		this.expires_in = expires_in;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public String getToken() {
		return token;
	} 

}