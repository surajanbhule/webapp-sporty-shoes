package com.surajanbhule.repositories;

import org.springframework.data.repository.CrudRepository;

import com.surajanbhule.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	public User findByUsernameAndPassword(String username,String password);
		
	
}
