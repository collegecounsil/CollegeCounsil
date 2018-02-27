package com.student.corner.SC.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.corner.SC.bean.UserBean;
import com.student.corner.SC.model.Role;
import com.student.corner.SC.model.User;
import com.student.corner.SC.service.RoleService;
import com.student.corner.SC.service.UserService;
import com.student.corner.SC.util.Constants.RoleMaster;
import com.student.corner.SC.util.Utility;

@RestController
public class UserController {
	
	@Autowired
	private Utility utility;
	
	@Autowired
	private UserService userService;
	
	 @Autowired
	private PasswordEncoder passwordEncoder;	

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value= "/register", method= RequestMethod.POST)
	public void register(@RequestBody UserBean userBean) {		
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleService.findByName(RoleMaster.ADMIN));		
		User user = new User();
		user.setFirstName(userBean.getFirstName());
		user.setLastName(userBean.getLastName());
		user.setPassword(passwordEncoder.encode(userBean.getPassword()));
		user.setEmail(userBean.getEmail());
		user.setLastLogin(new Date());
		user.setPhone(userBean.getPhone());
		user.setLastPasswordResetDate(new Date());
		user.setUserKey("my-user");
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setActive(true);
		user.setRoles(roles);
		userService.save(user);
		
	}
}
