package com.techsaby.SpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techsaby.SpringBoot.domain.User;
import com.techsaby.SpringBoot.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/list")
	public Iterable<User> list(){
		return userService.list();
	}
	
	
}
