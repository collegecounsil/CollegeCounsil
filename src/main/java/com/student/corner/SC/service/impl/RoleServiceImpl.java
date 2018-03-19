package com.student.corner.SC.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.corner.SC.model.Role;
import com.student.corner.SC.repository.RoleRepository;
import com.student.corner.SC.service.RoleService;
import com.student.corner.SC.util.Constants.RoleMaster;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	@Transactional(value = "transactionManager")
	public List<Role> list() {
		return roleRepository.findAll();
	}

	@Override
	@Transactional(value = "transactionManager")
	public void save(Role role) {
		roleRepository.save(role);
	}

	@Override
	@Transactional(value = "transactionManager")
	public Role findByName(RoleMaster name) {
		return roleRepository.findByName(name);
	}
}
