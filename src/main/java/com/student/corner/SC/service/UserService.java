package com.student.corner.SC.service;

import com.student.corner.SC.model.User;

/**
 * 
 * @author Raj
 * @since V1.0.0_14012017
 */
public interface UserService {
	public void save(User user);
	public User findUserByEmail(String email);
}