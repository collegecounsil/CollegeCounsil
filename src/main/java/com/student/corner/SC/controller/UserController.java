package com.student.corner.SC.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.corner.SC.bean.UserBean;

@RestController
public class UserController {
	
	@RequestMapping(value= "/register", method= RequestMethod.POST)
	public void register(@RequestBody UserBean user) {
		System.out.println(user.getEmail());
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getPassword());
		System.out.println(user.getPhone());
	}
}
