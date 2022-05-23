package com.techsaby.SpringBoot.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.techsaby.SpringBoot.domain.User;
import com.techsaby.SpringBoot.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	
	public Iterable<User> list() {
		return userRepository.findAll();
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public Iterable<User> save(List<User> users) {
		return userRepository.saveAll(users);
	}

}
