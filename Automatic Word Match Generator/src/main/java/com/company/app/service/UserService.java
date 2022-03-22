package com.company.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.model.User;
import com.company.app.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public User findById(int id) {
		return userRepository.findById(id);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}
	
	public User updateUserById(User user, int id) {
		User userToUpdate = userRepository.findById(id);
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setUserName(user.getUserName());
		userRepository.save(user);
		return userToUpdate;
	}
}
