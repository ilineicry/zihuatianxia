package com.zihuatianxia.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {

	public static void sendMail(String email, String emailMsg) throws AddressException, MessagingException {
				
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "SMTP");
		props.setProperty("mail.host", "smtp.126.com");
		props.setProperty("mail.smtp.auth", "true"); 
	
		Authenticator auth = new Authenticator(){
			public PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("zihuatianxia", "hao12345");
			}
		};
		
		Session session = Session.getInstance(props, auth);
		
		Message message = new MimeMessage(session);
		
		message.setFrom(new InternetAddress("zihuatianxia@126.com")); 
		
		message.setRecipient(RecipientType.TO, new InternetAddress(email)); 
		
		message.setSubject("用户激活");
		
		message.setContent(emailMsg, "text/html;charset=utf-8");
		
		Transport.send(message);
		
	}
}
