package com.student.corner.SC.listener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.student.corner.SC.model.Role;
import com.student.corner.SC.model.User;
import com.student.corner.SC.service.RoleService;
import com.student.corner.SC.service.UserService;
import com.student.corner.SC.util.Constants.RoleMaster;

@Component
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;

	@Value("${super.admin.password}")
	public String SUPER_ADMIN_PASSWORD;

	@Value("${super.admin.first.name}")
	public String SUPER_ADMIN_FIRST_NAME;

	@Value("${super.admin.last.name}")
	public String SUPER_ADMIN_LAST_NAME;

	@Value("${super.admin.email}")
	public String SUPER_ADMIN_EMAIL;
	
	@Value("${super.admin.phone}")
	public String SUPER_ADMIN_PHONE;
	
	

	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
		if (applicationContext.getParent() == null) { // Root Parent initialized
			createMasterRoles();
			createSuperAdminUser();
		}
	}

	public void createMasterRoles() {
		// Super Admin Role
		Role roleSuperAdmin = roleService.findByName(RoleMaster.SUPERADMIN);
		if (roleSuperAdmin == null) {
			roleSuperAdmin = new Role();
			roleSuperAdmin.setName(RoleMaster.SUPERADMIN);
			roleSuperAdmin.setUiName(RoleMaster.SUPERADMIN.getValue());
			roleService.save(roleSuperAdmin);
		}

		// Employer Role
		Role roleEmployer = roleService.findByName(RoleMaster.ADMIN);
		if (roleEmployer == null) {
			roleEmployer = new Role();
			roleEmployer.setName(RoleMaster.ADMIN);
			roleEmployer.setUiName(RoleMaster.ADMIN.getValue());
			roleService.save(roleEmployer);
		}

		// HR Manager Role
		Role roleHRManager = roleService.findByName(RoleMaster.TEACHER);
		if (roleHRManager == null) {
			roleHRManager = new Role();
			roleHRManager.setName(RoleMaster.TEACHER);
			roleHRManager.setUiName(RoleMaster.TEACHER.getValue());
			roleService.save(roleHRManager);
		}

		// Job Seeker Role
		Role roleJobSekker = roleService.findByName(RoleMaster.STUDENT);
		if (roleJobSekker == null) {
			roleJobSekker = new Role();
			roleJobSekker.setName(RoleMaster.STUDENT);
			roleJobSekker.setUiName(RoleMaster.STUDENT.getValue());
			roleService.save(roleJobSekker);
		}
	}


	public void createSuperAdminUser() {
		User superAdminUser = userService.findUserByEmail(SUPER_ADMIN_EMAIL);
		if (superAdminUser == null) {
			superAdminUser = new User();
			superAdminUser.setFirstName(SUPER_ADMIN_FIRST_NAME);
			superAdminUser.setLastName(SUPER_ADMIN_LAST_NAME);
			superAdminUser.setPassword(SUPER_ADMIN_PASSWORD);
			superAdminUser.setEmail(SUPER_ADMIN_EMAIL);
			superAdminUser.setPhone(SUPER_ADMIN_PHONE);
			superAdminUser.setLastPasswordResetDate(new Date());
			superAdminUser.setLastLogin(new Date());
			superAdminUser.setAccountNonExpired(true);
			superAdminUser.setAccountNonLocked(true);
			superAdminUser.setActive(true);
			
			List<Role> superAdminRole = new ArrayList<Role>();
			superAdminRole.add(roleService.findByName(RoleMaster.SUPERADMIN));
			superAdminUser.setRoles(superAdminRole);
			userService.save(superAdminUser);
		}
	}
}
