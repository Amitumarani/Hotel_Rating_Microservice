package com.lcwd.user.service.UserService.service.impl;

import java.util.List;

import com.lcwd.user.service.UserService.dto.User;

public interface UserService {
	
	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(int userId);

}
