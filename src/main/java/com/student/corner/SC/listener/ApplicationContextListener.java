package com.student.corner.SC.listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.student.corner.SC.model.Role;
import com.student.corner.SC.service.RoleService;
import com.student.corner.SC.util.Constants.RoleMaster;

/**
 * Application Context Listener used for Bootstrapping Initial Data to DB Will
 * run when Application starts
 * 
 * @author RM
 * @since V1.0.0_01102017
 */
@Component
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {


	@Autowired
	private RoleService roleService;

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
		
	}
}
