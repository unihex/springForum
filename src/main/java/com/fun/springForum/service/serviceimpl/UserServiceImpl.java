package com.fun.springForum.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fun.springForum.domain.User;
import com.fun.springForum.repository.UserRepository;
import com.fun.springForum.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}
	
	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public boolean isUserExist(Long userId) {
		return userRepository.exists(userId);
	}
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

}
