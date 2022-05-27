package com.orenda.lifesecure.service;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.orenda.lifesecure.dao.LifeSecureLoginDao;
import com.orenda.lifesecure.model.User;
import com.orenda.lifesecure.model.UserDetails;

@Service

public class LifeSecureLoginServiceImpl implements LifeSecureLoginService {

	@Autowired
	LifeSecureLoginDao loginDao;
	
	//login code
	
	@Override
    public UserDetails verifyUserCredentilas(String username, String password) {
		
		System.out.println("service");
		User user = loginDao.getUserDetailsByEmailId(username);
		UserDetails userdetails=null;

		if (username != null && user != null && user.getPassword() != null && user.getPassword().equals(password)) {
			try {
			 userdetails = loginDao.getUserType(username);
			}catch(Exception e) {
				e.printStackTrace();
			}

		}
		return userdetails;
	}
	
	//forgot code

	@Override
	public boolean getUserByEmail(String emailId) {

		User user = loginDao.getUserInDb(emailId);
		if (user == null) {
			System.out.println("user is null");
			return false;
		}
		if (user.getEmail().equalsIgnoreCase(emailId)) {
			return true;
		}
		return false;

	}

	@Override
	public boolean sendEmail(String msg, String subject, String from, String to) {

		Properties properties = System.getProperties();

		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", 465);
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, "life@123");
			}
		};

		Session session = Session.getInstance(properties, auth);
		try {
			MimeMessage mimemsg = new MimeMessage(session);
			mimemsg.setFrom(from);
			mimemsg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimemsg.setText(msg);
			mimemsg.setSubject(subject);

			Transport.send(mimemsg);
			System.out.println("sent suceess");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean verifyOtp(String emailId, String newPassword) {

		// System.out.println("emailId and new password"+emailId+","+newPassword);

		return loginDao.resetPasswordDb(emailId, newPassword);

	}

}
