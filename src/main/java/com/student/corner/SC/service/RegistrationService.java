package com.student.corner.SC.service;

import com.student.corner.SC.bean.CommonBO;

public interface RegistrationService {

	public CommonBO sendVerificationMailToUser(String email);	
	public CommonBO sendCongratulationMailToUser(String email,String password);
}
