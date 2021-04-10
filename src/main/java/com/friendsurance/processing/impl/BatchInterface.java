package com.friendsurance.processing.impl;

import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailService;

/**
 * Interface used to get MailType out of User information
 * @author Onkar
 *
 */
@FunctionalInterface
public interface BatchInterface {

	EmailService.MailType getMailType(User user);
}
