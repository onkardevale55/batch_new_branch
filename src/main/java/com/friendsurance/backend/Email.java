package com.friendsurance.backend;

import com.friendsurance.mail.EmailRecipient;
import com.friendsurance.mail.EmailService;

/**
 * Encapsulates information about user email details
 * @author Onkar
 *
 */
public class Email {

	private EmailService.MailType mailType;
	private EmailRecipient recipient; 
	
	public Email(EmailService.MailType mailType, EmailRecipient recipientEmail) {
		this.mailType = mailType;
		this.recipient = recipientEmail;
	}

	public EmailService.MailType getMailType() {
		return mailType;
	}
	
	public EmailRecipient getRecipient() {
		return recipient;
	}
}
