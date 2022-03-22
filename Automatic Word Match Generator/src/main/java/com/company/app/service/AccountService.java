package com.company.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.model.Account;
import com.company.app.repository.AccountRepository;

@Service
public class AccountService {
	
	private AccountRepository accountRepository;
	
	@Autowired
	AccountService(AccountRepository accountRepository){
		this.accountRepository = accountRepository;
	}
	
	public Account save(Account account) {
		return accountRepository.save(account);
	}
	
	public void deleteById(int id) {
		accountRepository.deleteById(id);
	}
	
	public Account updateAccount(Account account, int id) {
		Account accountToUpdate = accountRepository.findById(id);
		accountToUpdate.setBillingAddress(account.getBillingAddress());
		accountToUpdate.setBillingCountry(account.getBillingCountry());
		accountToUpdate.setBillingProvince(account.getBillingProvince());
		accountToUpdate.setPhoneNumber(account.getPhoneNumber());
		accountToUpdate.setZip(account.getZip());
		accountToUpdate = accountRepository.save(account);
		return accountToUpdate;
	}
	
	public Account findById(int id) {
		return accountRepository.findById(id);
	}
	
	public Account findByUserId(int id) {
		return accountRepository.findByUserId(id);
	}

}
