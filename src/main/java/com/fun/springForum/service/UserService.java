package com.fun.springForum.service;

import java.util.List;

import com.fun.springForum.domain.User;

public interface UserService {
	
	User findById(Long id);
	List<User> findAllUsers();
	boolean isUserExist(Long userId);
	User saveUser(User user);

}
