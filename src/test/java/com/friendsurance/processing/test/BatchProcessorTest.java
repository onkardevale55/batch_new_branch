package com.friendsurance.processing.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.friendsurance.backend.Email;
import com.friendsurance.backend.User;
import com.friendsurance.mail.impl.EmailServiceImpl;
import com.friendsurance.processing.ItemProcessing;
import com.friendsurance.processing.impl.BatchProcessor;
import com.friendsurance.processing.impl.EmailWriter;
import com.friendsurance.processing.impl.UserInfoReader;

/**
 * Test Batch Processor, passing multiple users
 * @author Omkar
 *
 */
public class BatchProcessorTest {

	private List<User> users = new ArrayList<User>();
	
	@Before
	public void setup() {
		users.add(new User("onkardevale@gmail.com", false, 2, 4));
		users.add(new User("onkardevale21@gmail.com", true, 0, 2));
		users.add(new User("onkardevale21@gmail.com", true, 10, 10));
		users.add(new User("onkardevale@gmail.com", true, 10, 0));
		users.add(new User("xyz.astra@gmail.com", false, 4, 2));
		users.add(new User("xyz.astra@gmail.com", false, 2, 2));
		users.add(new User("xyz.astra@gmail.com", true, 0, 0));
		users.add(new User("pqr.astra@gmail.com", false, 2, 0));
		users.add(new User("pqr.astra@gmail.com", true, 2, 0));
	}
	
	@Test
	public void testBatchProcessor(){
		ItemProcessing<User, Email> ip = new BatchProcessor(new UserInfoReader(users), new EmailWriter(new EmailServiceImpl()));
		ip.doProcessing();
	}
}
