package com.student.corner.SC.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.corner.SC.model.User;
import com.student.corner.SC.repository.UserRepository;
import com.student.corner.SC.service.UserService;
import com.student.corner.SC.util.Constants.KeyType;
import com.student.corner.SC.util.Utility;

/**
 * 
 * @author Raj
 * @since V1.0.0_14012017
 */

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
    
	@Autowired
	private Utility utility;
    
	@Override
	@Transactional(value = "transactionManager")
	public void save(User user) {
		if (user.getId() == null) {
			// New user creation
			user.setPassword(utility.encodePassword(user.getPassword()));
		}
		user.setUserKey(utility.genrateKey(KeyType.STUDENT_KEY));
		userRepository.save(user);
	}
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}