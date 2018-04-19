package com.student.corner.SC.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

import com.student.corner.SC.util.Constants.KeyType;

@Service("utility")
public class Utility {
	
	@Value("${application.private.key}")
	public String APP_PRIVATE_KEY;//
	
	private final Log LOGGER = LogFactory.getLog(this.getClass());
	
	public static final String algorithm = "DES";
	
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
	
	public String encrypt(String stringToBeEncrypted) {
		String encryptedString = null;
		try {
			DESKeySpec dks = new DESKeySpec(this.APP_PRIVATE_KEY.getBytes());
			SecretKeyFactory skf = SecretKeyFactory.getInstance(Utility.algorithm);
			SecretKey desKey = skf.generateSecret(dks);
			Cipher cipher = Cipher.getInstance(Utility.algorithm);
			cipher.init(Cipher.ENCRYPT_MODE, desKey);
			byte[] inputBytes = cipher.doFinal(stringToBeEncrypted.getBytes());
			encryptedString = new String(Base64.encode(inputBytes));
		} catch (InvalidKeyException e) {
			LOGGER.error("InvalidKeyException while encrypting String:" + stringToBeEncrypted + " with Exception:" + e);
		} catch (BadPaddingException e) {
			LOGGER.error("BadPaddingException while encrypting String:" + stringToBeEncrypted + " with Exception:" + e);
		} catch (IllegalBlockSizeException e) {
			LOGGER.error("IllegalBlockSizeException while encrypting String:" + stringToBeEncrypted + " with Exception:"
					+ e);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error(
					"NoSuchAlgorithmException while encrypting String:" + stringToBeEncrypted + " with Exception:" + e);
		} catch (NoSuchPaddingException e) {
			LOGGER.error(
					"NoSuchPaddingException while encrypting String:" + stringToBeEncrypted + " with Exception:" + e);
		} catch (InvalidKeySpecException e) {
			LOGGER.error(
					"InvalidKeySpecException while encrypting String:" + stringToBeEncrypted + " with Exception:" + e);
		}
		return encryptedString;
	}
	
	public String decrypt(String stringToBeDecrypted) {
		String descryptedString = null;
		try {
			DESKeySpec dks = new DESKeySpec(this.APP_PRIVATE_KEY.getBytes());
			SecretKeyFactory skf = SecretKeyFactory.getInstance(Utility.algorithm);
			SecretKey desKey = skf.generateSecret(dks);
			Cipher cipher = Cipher.getInstance(Utility.algorithm);
			cipher.init(Cipher.DECRYPT_MODE, desKey);
			byte[] recoveredBytes = cipher.doFinal(Base64.decode(stringToBeDecrypted.getBytes()));
			descryptedString = new String(recoveredBytes);
		} catch (InvalidKeyException e) {
			LOGGER.error("InvalidKeyException while decrypting String:" + stringToBeDecrypted + " with Exception:" + e);
		} catch (BadPaddingException e) {
			LOGGER.error("BadPaddingException while decrypting String:" + stringToBeDecrypted + " with Exception:" + e);
		} catch (IllegalBlockSizeException e) {
			LOGGER.error("IllegalBlockSizeException while decrypting String:" + stringToBeDecrypted + " with Exception:"
					+ e);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error(
					"NoSuchAlgorithmException while decrypting String:" + stringToBeDecrypted + " with Exception:" + e);
		} catch (NoSuchPaddingException e) {
			LOGGER.error(
					"NoSuchPaddingException while decrypting String:" + stringToBeDecrypted + " with Exception:" + e);
		} catch (InvalidKeySpecException e) {
			LOGGER.error(
					"InvalidKeySpecException while decrypting String:" + stringToBeDecrypted + " with Exception:" + e);
		}
		return descryptedString;
	}
	
	public String replaceText(String source, Map<String, String> replacers) {
		for (String replacer : replacers.keySet()) {
			String replacerText = replacers.get(replacer);
			source = source.replace(replacer, replacerText);
		}
		return source;
	}
}
