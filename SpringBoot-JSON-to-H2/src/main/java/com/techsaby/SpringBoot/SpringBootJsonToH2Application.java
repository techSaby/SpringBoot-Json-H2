package com.techsaby.SpringBoot;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.techsaby.SpringBoot.service.UserService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import com.techsaby.SpringBoot.domain.User;

@SpringBootApplication
public class SpringBootJsonToH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJsonToH2Application.class, args);
	}
	
	
	@Bean
	CommandLineRunner runner(UserService userService) {
		return args -> {
			//read json and write in db
			ObjectMapper objectMapper = new ObjectMapper();	
			TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
			InputStream inputStream = 
					TypeReference.class.getResourceAsStream("/json/users.json");
			try {
			List<User> users = objectMapper.readValue(inputStream, typeReference);
			userService.save(users);
			System.out.println("User Saved!");
			}catch(IOException e) {
				System.out.println("Unable to save user! "+e.getMessage());
			}
		};
	}

}
