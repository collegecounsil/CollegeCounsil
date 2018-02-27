package com.student.corner.SC.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.corner.SC.model.Role;
import com.student.corner.SC.repository.RoleRepository;
import com.student.corner.SC.service.RoleService;
import com.student.corner.SC.util.Constants.RoleMaster;

/**
 * Implementation class for Role Service
 * 
 * @author RM
 * @since V1.0.0_01102017
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	/**
	 * Method Implementation used to find all the Roles
	 * 
	 * @return List of Roles
	 * @author RM
	 * @since V1.0.0_01112017
	 */
	@Override
	@Transactional(value = "transactionManager")
	public List<Role> list() {
		return roleRepository.findAll();
	}

	/**
	 * Method Implementation used to store role in DB
	 * 
	 * @author RM
	 * @since V1.0.0_01112017
	 */
	@Override
	@Transactional(value = "transactionManager")
	public void save(Role role) {
		roleRepository.save(role);
	}

	/**
	 * Method Implementation to Find Role By name from Database
	 * 
	 * @return Role Object
	 * @author RM
	 * @since V1.0.0_01112017
	 */
	@Override
	@Transactional(value = "transactionManager")
	public Role findByName(RoleMaster name) {
		return roleRepository.findByName(name);
	}
}
