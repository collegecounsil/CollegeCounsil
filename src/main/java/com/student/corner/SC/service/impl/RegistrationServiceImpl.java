package com.student.corner.SC.service.impl;

import java.net.URLEncoder;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.student.corner.SC.bean.CommonBO;
import com.student.corner.SC.model.User;
import com.student.corner.SC.service.RegistrationService;
import com.student.corner.SC.service.UserService;
import com.student.corner.SC.util.Utility;



@Service("RegistrationService")
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private Utility utility;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageSource messageSource;

	@Override
	public CommonBO sendVerificationMailToUser(String email) {
		CommonBO commonBO = new CommonBO();
		User user = userService.findUserByEmail(email);
		if(user !=null){ 
//			String key = URLEncoder.encode(utility.encrypt(user.getId() + utility.SEPARATOR + new Date().getTime()), "UTF-8");
		}
		return null;
	}

	@Override
	public CommonBO sendCongratulationMailToUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
