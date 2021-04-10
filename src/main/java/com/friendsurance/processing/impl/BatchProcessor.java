package com.friendsurance.processing.impl;

import com.friendsurance.backend.Email;
import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailService.MailType;
import com.friendsurance.mail.impl.EmailReciepientImpl;
import com.friendsurance.processing.ItemProcessing;
import com.friendsurance.processing.ItemReader;
import com.friendsurance.processing.ItemWriter;
import com.friendsurance.utils.BatchUtils;

/**
 * Batch Processor which is invoked by client
 * @author Onkar
 *
 */
public class BatchProcessor extends ItemProcessing<User, Email>{

	public BatchProcessor(ItemReader<User> reader, ItemWriter<Email> writer) {
		super(reader, writer);
	}

	/**
	 * Method process input User object and return Email details
	 */
	@Override
	protected Email process(User user) {
		System.out.println("Processing user :" + user);
		MailType mailType = BatchUtils.BATCH_FUNCTION.getMailType(user);		
		return new Email(mailType, new EmailReciepientImpl(user.getEmail()));
	}
	
}
