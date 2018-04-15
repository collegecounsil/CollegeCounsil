package com.student.corner.SC.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.corner.SC.bean.CommonBO;
import com.student.corner.SC.bean.UserBean;
import com.student.corner.SC.model.Role;
import com.student.corner.SC.model.User;
import com.student.corner.SC.service.RegistrationService;
import com.student.corner.SC.service.RoleService;
import com.student.corner.SC.service.UserService;
import com.student.corner.SC.util.Constants.RoleMaster;
import com.student.corner.SC.util.Utility;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private Utility utility;
	
	@Autowired
	private RegistrationService registrationService;
	
	@RequestMapping(value= "/register", method= RequestMethod.POST)
	public void register(@Valid @RequestBody UserBean userBean) {
		CommonBO commonBO = new CommonBO();
		try {
			if(utility.matchPasswordPolicy(userBean.getPassword())) {
				if(validateUsername(userBean.getEmail())) {
					List<Role> roles = new ArrayList<Role>();
					roles.add(roleService.findByName(RoleMaster.ADMIN));		
					User user = new User();
					user.setFirstName(userBean.getFirstName());
					user.setLastName(userBean.getLastName());
					user.setPassword(userBean.getPassword());
					user.setEmail(userBean.getEmail());
					user.setLastLogin(new Date());
					user.setPhone(userBean.getPhone());
					user.setLastPasswordResetDate(new Date());
					user.setAccountNonExpired(true);
					user.setAccountNonLocked(true);
					user.setActive(true);
					user.setRoles(roles);
					userService.save(user);
					
					commonBO = registrationService.sendVerificationMailToUser(user.getEmail());
					
				} else {
					commonBO.setStatus("error");
					commonBO.setMessage("Email '"+ userBean.getEmail() + "' already exists");
				}
			} else {
				commonBO.setStatus("error");
				commonBO.setMessage("Password policy not followed");
			}
		} catch(Exception e ) {
			
		}
	}
	
	public Boolean validateUsername(String email){
		User user = userService.findUserByEmail(email);
		return user == null;
	}
}
