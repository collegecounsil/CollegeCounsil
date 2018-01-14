package com.student.corner.SC.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Contains All Application utility 
 * 
 * @author Raj
 * @since V1.0.0_14012017
 */
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

}
