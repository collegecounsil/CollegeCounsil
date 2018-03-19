package com.student.corner.SC.service;

import java.util.List;

import com.student.corner.SC.model.Role;
import com.student.corner.SC.util.Constants.RoleMaster;

public interface RoleService {
	public List<Role> list();
	public void save(Role role);
	public Role findByName(RoleMaster name);
}
