package com.student.corner.SC.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.corner.SC.model.User;

/**
 * 
 * @author Raj
 * @since V1.0.0_14012017
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	 User findByEmail(String email);
}