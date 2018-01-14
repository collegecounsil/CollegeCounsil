package com.student.corner.SC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.corner.SC.model.Role;

/**
 * 
 * @author Raj
 * @since V1.0.0_14012017
 */
@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByRole(String role);

}