package com.student.corner.SC.security;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Map;

/**
 * Custom User Details of Current Logged-in User
 * 
 * @author RM
 * @since V1.0.0_01092017
 */
public class CustomUserDetails extends User {

	/**
	 * Generated Serial Version ID
	 */
	private static final long serialVersionUID = -2319213560125289957L;
	private Map<String, Object> config;
	
	public CustomUserDetails(String email, String password,  boolean active, boolean accountNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Map<String, Object> config) {
        super(email, password, active, accountNonExpired, true, accountNonLocked, authorities);
        this.config = config;
    }
	
	public Map<String, Object> getConfig() {
		return config;
	}
}
