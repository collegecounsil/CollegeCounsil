package com.student.corner.SC.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.corner.SC.model.Role;
import com.student.corner.SC.model.User;
import com.student.corner.SC.service.UserService;


/**
 * Spring Security User Details Service Implementation to get User details 
 * 
 * @author Raj
 * @since V1.0.0_14012017
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private UserService userService;
	
	@Override
	@Transactional(value = "transactionManager")
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userService.findUserByEmail(email);
		if(user != null) {
			String password = user.getPassword();
			boolean isActive = user.isActive();
			boolean accountNonExpired = user.isAccountNonExpired();	
			boolean accountNonLocked = user.isAccountNonLocked();
			
			//Populating Roles
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for(Role role: user.getRoles()) {
				authorities.add(new SimpleGrantedAuthority(role.getRole().name()));
			}
			
			//Setting last login time
			user.setLastLogin(new Date());
			userService.save(user);
			
			Map<String, Object> config = new HashMap<String, Object>();
			
			
			//Creating Spring-Security User
			CustomUserDetails userDetails = new CustomUserDetails(email, password, isActive, accountNonExpired, accountNonLocked, authorities, config);
			return userDetails;
		} else {
			throw new UsernameNotFoundException("User Not Found");
		}
	}
}
