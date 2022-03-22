package com.company.app.test;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.company.app.model.User;
import com.company.app.repository.UserRepository;
import com.company.app.service.UserService;

public class UserServiceTest {
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserService userService;
	
	@BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void checkCreateUser() {
		User user = new User("JohnDoe","password");
		when(userRepository.save(user)).thenReturn(user);
		User createdUser = userService.save(user);
		assertEquals(createdUser.getUserName(),user.getUserName());
		assertEquals(createdUser.getPassword(),user.getPassword());
	}
	
	@Test
	public void checkUpdateUser() {
		User user = new User("JohnDoe","password");
		when(userRepository.findById(ArgumentMatchers.eq(1))).thenReturn(user);
		
		User modifiedUser = new User("John","password123");
		
		User updatedUser = userService.updateUserById(modifiedUser,1);
		assertEquals(modifiedUser.getPassword(),updatedUser.getPassword());
		assertEquals(modifiedUser.getUserName(),updatedUser.getUserName());
	}
	
	@Test
	public void checkFindUser() {
		User user = new User("JohnDoe","password");
		when(userRepository.findById(ArgumentMatchers.eq(1))).thenReturn(user);
		User createdUser = userService.findById(1);
		assertEquals(createdUser,user);
	}

}
