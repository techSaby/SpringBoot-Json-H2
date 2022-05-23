package com.techsaby.SpringBoot.repository;

import org.springframework.data.repository.CrudRepository;

import com.techsaby.SpringBoot.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
