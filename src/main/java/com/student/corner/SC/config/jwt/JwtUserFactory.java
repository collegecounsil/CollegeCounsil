package com.student.corner.SC.config.jwt;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.student.corner.SC.model.Role;
import com.student.corner.SC.model.User;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
		//Populating Roles
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for(Role role: user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName().name()));
		}
    	
        return new JwtUser(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(), authorities, user.isActive(), user.getLastPasswordResetDate());
    }

}
