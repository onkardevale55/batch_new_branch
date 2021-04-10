package com.friendsurance.utils;

import java.util.Comparator;
import java.util.Optional;

import com.friendsurance.backend.User;
import com.friendsurance.mail.EmailService;
import com.friendsurance.processing.impl.BatchInterface;

/**
 * Used to implement Batch business logic
 * @author Onkar
 *
 */
public class BatchUtils {

	/**
	 * Functional interface implementation using lambda to get MailType
	 */
	public static final BatchInterface BATCH_FUNCTION = (user) -> 
	{
		int friends = user.getFriendsNumber();
		int invitations = user.getSentInvitationsNumber();
		Optional<EmailService.MailType> mailtype =Optional.empty();
		if(!user.hasContract()) {
			if((friends == 0 && invitations==0) || (friends < 3 && invitations > 1)) {
				mailtype = Optional.of(EmailService.MailType.MAIL_TYPE_2);
			}
			
			if((friends > 1 && invitations==0) || (friends < 3 && invitations > 6)) {
				mailtype = Optional.of(EmailService.MailType.MAIL_TYPE_3);
			}
			
			if((friends > 3 && invitations > 1)) {
				mailtype = Optional.of(EmailService.MailType.MAIL_TYPE_1);
			}
		} else {
			if((friends == 0 && invitations==0) || (friends == 0 && invitations > 3)) {
				mailtype = Optional.of(EmailService.MailType.MAIL_TYPE_3);
			}
			
			if((friends > 1)) {
				mailtype = Optional.of(EmailService.MailType.MAIL_TYPE_4);
			}
			
			if((friends > 4 && invitations > 4)) {
				mailtype = Optional.of(EmailService.MailType.MAIL_TYPE_5);
			}
		}
		return mailtype.isPresent()?mailtype.get():null;
	};
	
	/**
	 * Comparator to sort users list based on Mail Priority
	 */
	public static final Comparator<User> PRIORITY_COMPARATOR = (user1, user2)->{
		final Integer priorityUser1 = BatchUtils.getPriorityOfMail(BatchUtils.BATCH_FUNCTION.getMailType(user1));
		final Integer priorityUser2 = BatchUtils.getPriorityOfMail(BatchUtils.BATCH_FUNCTION.getMailType(user2));
		if(priorityUser1.compareTo(priorityUser2) < 0) {
			return 1;
		} else if(priorityUser1.compareTo(priorityUser2) > 0) {
			return -1;
		}
		return 0;
	};
	
	/**
	 * Get Mail Priority
	 * @param mailtype
	 * @return int
	 */
	public static int getPriorityOfMail(EmailService.MailType mailtype) {
		if(mailtype!=null) {
			String[] split = mailtype.name().split("_");
			return Integer.valueOf(split[2]);
		}
		return 0;
	}
}
