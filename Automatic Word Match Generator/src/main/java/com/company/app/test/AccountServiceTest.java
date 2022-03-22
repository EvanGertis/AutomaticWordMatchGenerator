package com.company.app.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.company.app.model.Account;
import com.company.app.model.Book;
import com.company.app.repository.AccountRepository;
import com.company.app.service.AccountService;

public class AccountServiceTest {
	
	@Mock
	AccountRepository accountRepository;
	
	@InjectMocks
	AccountService accountService;
	
	@BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void checkCreateAccount() {
		Account account = new Account();
		account.setBillingAddress("123 Fake street");
		account.setBillingCountry("US");
		account.setBillingProvince("NY");
		account.setPhoneNumber("555-555-5555");
		account.setUserId(1);
		account.setZip("12345");
		when(accountRepository.save(ArgumentMatchers.any())).thenReturn(account);
		Account createdAccount = accountService.save(account);
		assertEquals(createdAccount,account);
	}
	

}
