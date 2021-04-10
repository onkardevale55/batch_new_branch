package com.friendsurance.processing.test;

import org.junit.Test;

import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailService;
import com.friendsurance.mail.EmailService.MailType;
import com.friendsurance.utils.BatchUtils;

import org.junit.Assert;

/**
 * Test Mail Types
 * @author Onkar
 *
 */
public class BatchUtilsTest {
	
	@Test
	public void testMailType_5() {
		Assert.assertEquals(EmailService.MailType.MAIL_TYPE_5, 
				BatchUtils.BATCH_FUNCTION.getMailType(new User("onkardevale@gmail.com", true, 10, 10)));
	}
	
	@Test
	public void testMailType_4() {
		Assert.assertEquals(EmailService.MailType.MAIL_TYPE_4, 
				BatchUtils.BATCH_FUNCTION.getMailType(new User("onkardevale@gmail.com", true, 2, 0)));
	}
	
	@Test
	public void testMailType_3() {
		Assert.assertEquals(EmailService.MailType.MAIL_TYPE_3, 
				BatchUtils.BATCH_FUNCTION.getMailType(new User("onkardevale@gmail.com", false, 10, 0)));
		Assert.assertEquals(EmailService.MailType.MAIL_TYPE_3, 
				BatchUtils.BATCH_FUNCTION.getMailType(new User("onkardevale@gmail.com", false, 2, 8)));
		
		Assert.assertEquals(EmailService.MailType.MAIL_TYPE_3, 
				BatchUtils.BATCH_FUNCTION.getMailType(new User("onkardevale@gmail.com", true, 0, 0)));
		Assert.assertEquals(EmailService.MailType.MAIL_TYPE_3, 
				BatchUtils.BATCH_FUNCTION.getMailType(new User("onkardevale@gmail.com", true, 0, 8)));
	}
	
	@Test
	public void testMailType_2() {
		Assert.assertEquals(EmailService.MailType.MAIL_TYPE_2, 
				BatchUtils.BATCH_FUNCTION.getMailType(new User("onkardevale@gmail.com", false, 0, 0)));
	}
	
	@Test
	public void testMailType_1() {
		Assert.assertEquals(EmailService.MailType.MAIL_TYPE_1, 
				BatchUtils.BATCH_FUNCTION.getMailType(new User("onkardevale@gmail.com", false, 10, 10)));
	}
	
	@Test
	public void testMailPriority() {
		Assert.assertEquals(4, BatchUtils.getPriorityOfMail(MailType.MAIL_TYPE_4));
	}
	
}
