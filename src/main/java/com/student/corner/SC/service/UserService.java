package com.student.corner.SC.service;

import com.student.corner.SC.model.User;

public interface UserService {
	public void save(User user);
	public User findUserByEmail(String email);
}