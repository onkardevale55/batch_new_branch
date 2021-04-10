package com.friendsurance.processing.impl;

import java.util.HashMap;
import java.util.Map;

import com.friendsurance.backend.Email;
import com.friendsurance.mail.EmailService;
import com.friendsurance.processing.ItemWriter;

/**
 * Email writer sending email to recipient with mail type 
 * @author Onkar
 *
 */
public class EmailWriter implements ItemWriter<Email>{

	private EmailService emailService;
	
	/**
	 * Map is used to store user email for which email is sent
	 */
	private Map<String, Boolean> map;
	
	public EmailWriter(EmailService emailService) {
		this.emailService = emailService;
		map = new HashMap<String, Boolean>();
	}
	
	@Override
	public void write(Email item) {
		// For same user having multiple MailType, latest user is considered to send email
		if(map.get(item.getRecipient().getEmail())==null) {
			this.emailService.sendMail(item.getRecipient(), item.getMailType());
			System.out.println("Mail sent to user :" + item.getRecipient().getEmail() + ", with mail type : "+ item.getMailType());
			map.put(item.getRecipient().getEmail(), true);
		} 
	}

}
