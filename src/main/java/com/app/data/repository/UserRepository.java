package com.app.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	public User findUserByName(String name);
	
}
