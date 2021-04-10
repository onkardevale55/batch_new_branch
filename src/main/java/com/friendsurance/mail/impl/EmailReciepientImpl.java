package com.friendsurance.mail.impl;

import com.friendsurance.mail.EmailRecipient;

/**
 * Get email recipient details
 * @author Onkar
 *
 */
public class EmailReciepientImpl implements EmailRecipient{

	/**
	 * Email address
	 */
	private String email;

	public EmailReciepientImpl(String email) {
		this.email = email;
	}

	@Override
	public String getEmail() {
		return email;
	}

}
