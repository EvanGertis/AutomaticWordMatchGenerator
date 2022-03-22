package com.company.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.app.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	User findById(int id);
	User findByUserName(String userName);
		
}