package com.friendsurance.processing.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.friendsurance.backend.User;
import com.friendsurance.processing.ItemReader;
import com.friendsurance.utils.BatchUtils;

/**
 * Read user from userList
 * @author Omkar
 *
 */
public class UserInfoReader implements ItemReader<User>{

	private List<User> userList;
	Map<String, Integer> map;
	/**
	 * Latest index of user in list
	 */
	private int index = 0 ;
	
	public UserInfoReader(List<User> userList){
		this.userList = new ArrayList<User>();
		this.userList.addAll(userList.stream().sorted(BatchUtils.PRIORITY_COMPARATOR).collect(Collectors.toList()));
	}
	
	@Override
	public User read() {
		User nextUser = null;
		if(index < userList.size()) {
			nextUser = userList.get(index);
			index++;
		} else {
			index = 0;
		}
		return nextUser;
	}

}
