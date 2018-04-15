package com.student.corner.SC.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.student.corner.SC.util.Constants.KeyType;

@Service("utility")
public class Utility {
	
	//Date Formats to be used in Application
	public static final String DATE_FORMAT_MMddyyyy_SLASH = "MM/dd/yyyy";
	public static final String DATE_FORMAT_MMddyyyyHHmm_SLASH = "MM/dd/yyyy HH:mm";
	public static final String DATE_FORMAT_MMddyyyyhhmma_SLASH = "MM/dd/yyyy hh:mm a";
	public static final String DATE_FORMAT_MMddyyyyhhmmssa_SLASH = "MM/dd/yyyy hh:mm:ss a";
	public static final String DATE_FORMAT_yyyyMMddHHmm00_HYPHEN = "yyyy-MM-dd HH:mm:00";
	public static final String DATE_FORMAT_NOTIFICATION_TEXT = "hh:mm a 'on' EEEE, MMMM, dd";
	public static final String TIME_FORMAT_NOTIFICATION_TEXT = "hh:mm a";
	public static final String DATE_FORMAT_NOTIFICATION_VOICE = "hh:mm a 'on' EEEE, MMMM, dd";
	public static final String TIME_FORMAT = "HH:mm";
	public static final String SEPARATOR = "~~~";
	private static final String PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}";
	private Pattern pattern;
	
	
	public Utility() {
		pattern = Pattern.compile(PASSWORD_PATTERN);
	}
	
	// Return Date into String format
	public static String dateToString() {
		return "";
	}
	
	// return Current Date & time For Attachment
	public static String getCurrentDateTimeForAttachment(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String current = sdf.format(now);
		current = current.replaceAll("\\ ", "_");
		current = current.replaceAll("\\:", "_");
		current = current.replaceAll("\\.", "_");
		current = current.replaceAll("\\-", "_");
		
		return "_"+current;
	}

	public String encodePassword(String rawPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encryptedString = passwordEncoder.encode(rawPassword);
		return encryptedString;
	}
	
	// This method is used to get generate unique key for Student, Teacher, Admin
	public String genrateKey(KeyType key) {
		return key.getValue() + "-" + UUID.randomUUID().toString();
	}
	
	public Boolean matchPasswordPolicy(final String password) {
		return pattern.matcher(password).matches();
	}
}
