package com.company.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.model.Account;
import com.company.app.model.Registration;
import com.company.app.model.User;
import com.company.app.repository.AccountRepository;
import com.company.app.repository.UserRepository;

@Service
public class RegistrationService {
	private AccountRepository accountRepository;
	private UserRepository userRepository;
	private final Logger logger = LogManager.getLogger(RegistrationService.class);
	
	@Autowired
	RegistrationService(AccountRepository accountRepository, UserRepository userRepository){
		this.accountRepository = accountRepository;
		this.userRepository = userRepository;
	}
	
	public Boolean createNewUser(Registration registration) {
		User user = new User();
		user.setUserName(registration.getUserName());
		user.setPassword(registration.getPassword());
		logger.info("attempting to create user: {}", user.toString());
		
		try {
			user = userRepository.save(user);			
		} catch(Exception e) {
			logger.error("Failed to register account: {}", e.getMessage());
			return false;
		}
		
		Account account = new Account();
		account.setUserId(user.getId());
		account.setBillingAddress(registration.getBillingAddress());
		account.setBillingCountry(registration.getBillingCountry());
		account.setBillingProvince(registration.getBillingProvince());
		account.setPhoneNumber(registration.getPhoneNumber());
		account.setZip(registration.getZip());
		logger.info("attempting to create account: {}", account);
		
		try {
			account = accountRepository.save(account);			
		} catch(Exception e) {
			logger.error("Failed to register account: {}", e.getMessage());
			return false;
		}
		
		
		return true;
	}
}
