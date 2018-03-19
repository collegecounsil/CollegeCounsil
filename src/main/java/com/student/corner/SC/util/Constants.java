package com.student.corner.SC.util;

public class Constants {
	
	private Constants() {
	}
	
	//  All User role Enums
	public enum UserRole{
		TEACHER,
		STUDENT,
		ADMIN,
		SUPERADMIN		
	}
	
	//  All API Connection Enums
	public enum ApiProvider {
		FACEBOOK,
		LINKEDIN,
		TWITTER,
		INSTAGRAM,
		GPLUS
	}
	
	// Connection Status for Api
	public enum ApiConnectionStatus {
		NOT_CONNECTED,
		CONNECTED,
		TOKEN_EXPIRED,
		CREDENTIALS_NOT_FOUND
	}

	// Role enum - which defines all the roles that are supported in application
	public enum RoleMaster {
		STUDENT("Student "),
		TEACHER("Teacher"),
		ADMIN("Admin"),
		SUPERADMIN("Super admin");
		
		private final String enumValue;
		RoleMaster(String enumValue) { this.enumValue = enumValue; }
	    public String getValue() { return enumValue; }
	}
	
	// Unique key Prefix
	public enum KeyType {
		STUDENT_KEY("STD"),
		TEACHER_KEY("TCHR"),
		ADMIN_KEY("ADMN"),
		SUPERADMIN_KEY("SADMN");

		private final String enumValue;

		private KeyType(String enumValue) {
			this.enumValue = enumValue;
		}

		public String getValue() {
			return enumValue;
		}
	}
}
