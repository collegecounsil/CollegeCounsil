package com.student.corner.SC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.corner.SC.model.Role;
import com.student.corner.SC.util.Constants.RoleMaster;

/**
 * Repository Layer for Role
 * 
 * @author RM
 * @since V1.0.0_01102017
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(RoleMaster role);
}
