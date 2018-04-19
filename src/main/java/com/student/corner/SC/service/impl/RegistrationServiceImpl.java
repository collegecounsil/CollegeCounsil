package com.student.corner.SC.service.impl;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.student.corner.SC.bean.CommonBO;
import com.student.corner.SC.model.User;
import com.student.corner.SC.service.RegistrationService;
import com.student.corner.SC.service.UserService;
import com.student.corner.SC.util.Utility;



@Service("RegistrationService")
public class RegistrationServiceImpl implements RegistrationService {

	private final Log LOGGER = LogFactory.getLog(this.getClass());
	
	@Value("${application.url}")
    private String APPLICATION_URL;
	
	@Value("${spring.mail.username}")//Gmail block emails if username and from name is differ (for server other then Gmail)
    private String MAIL_FROM;
	
	@Value("${user.registration.link.expire.limit}")
    private String USER_REGISTRATION_LINK_EXPIRE_LIMIT;
	
	@Value("${user.registration.email.template.subject}")
    private String USER_REGISTRATION_EMAIL_TEMPLATE_SUBJECT;
	
	@Value("${user.registration.email.template.body}")
    private String USER_REGISTRATION_EMAIL_TEMPLATE_BODY;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private Utility utility;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageSource messageSource;

	@Override
	public CommonBO sendVerificationMailToUser(String email) {
		CommonBO commonBO = new CommonBO();
		try {
			User user = userService.findUserByEmail(email);
			if(user !=null){
				String key = URLEncoder.encode(utility.encrypt(user.getId() + utility.SEPARATOR + new Date().getTime()), "UTF-8");
				String dataURL = this.APPLICATION_URL + "register/verifyUser?key=" + key;
				Map<String,String> replacers = new HashMap<String, String>();
		        replacers.put("[name]", user.getFirstName() != null ? user.getFirstName() : user.getEmail());
		        replacers.put("[url]", dataURL);
		        replacers.put("[minutes]", this.USER_REGISTRATION_LINK_EXPIRE_LIMIT);
		        
		        String emailTemplate = this.USER_REGISTRATION_EMAIL_TEMPLATE_BODY;
		        
		        String emailBody = utility.replaceText(emailTemplate, replacers);
				
		        MimeMessage msg = mailSender.createMimeMessage();
		        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		        helper.setFrom(this.MAIL_FROM);
		        helper.setTo(email);
		        msg.setSubject(this.USER_REGISTRATION_EMAIL_TEMPLATE_SUBJECT);
		        msg.setContent(emailBody, "text/html");
		
		        mailSender.send(msg);
		        commonBO.setStatus("success");
				commonBO.setMessage(messageSource.getMessage("user.registration.success", new String[] { email} , "Registration successful", null));
			}
			else{
				commonBO.setStatus("error");
				commonBO.setMessage(messageSource.getMessage("user.notFound.error", new String[] { email} , "User not found", null));
			}
		} catch(Exception e){
			
			LOGGER.error("Exception in sending mail to user: " + e);
			commonBO.setStatus("error");
			commonBO.setMessage(messageSource.getMessage("user.verification.mail.error", null , "Error in sending email ", null));
		}
		return commonBO;
	}

	@Override
	public CommonBO sendCongratulationMailToUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
