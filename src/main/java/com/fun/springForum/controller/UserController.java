package com.fun.springForum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fun.springForum.domain.User;
import com.fun.springForum.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user) {
		System.out.println("Creating User: " + user);
		
		if (userService.isUserExist(user.getUserId())) {
			String message = String.format("Unable to create. User with ID %d already exists\n", user.getUserId());
			
			System.out.println(message);
			return ResponseEntity.badRequest().body(message);
		}
		
		User savedUser = userService.saveUser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody User user) {
		System.out.println("Updating User: " + user);
		
		if (!userService.isUserExist(user.getUserId())) {
			String message = String.format("User with ID %d not found\n", user.getUserId());
			
			System.out.println(message);
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
		User savedUser = userService.saveUser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Long userId) {
		System.out.println("Getting User With ID: " + userId);
		User user = userService.findById(userId);
		
		if (user == null) {
			String message = String.format("User with ID %d not found\n", userId);
			
			System.out.println(message);
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		System.out.println("Getting all users");
		
		List<User> users = userService.findAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}
