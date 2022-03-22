package com.company.app.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.app.model.Account;
import com.company.app.model.Login;
import com.company.app.model.Registration;
import com.company.app.model.User;
import com.company.app.service.AccountService;
import com.company.app.service.RegistrationService;
import com.company.app.service.UserService;

@Controller
public class UserController {
	private static final Logger logger = LogManager.getLogger(UserController.class);
	private final UserService userService;
	private final AccountService accountService;
	private final RegistrationService registrationService;
	
	@Autowired
	public UserController(UserService userService, AccountService accountService, RegistrationService registrationService) {
		this.userService = userService;
		this.accountService = accountService;
		this.registrationService = registrationService;
	}
	
	@RequestMapping("/user/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/user/logout")
	public String logout(HttpSession session) {
		try {
			session.removeAttribute("username");
			session.removeAttribute("userId");
		}
		catch (Exception e) {
			logger.error("/user/logout {}", e.getMessage());
			return "logout";
		}
		return "logout";
	}
	
	@RequestMapping("/user/registration")
	public String showRegistration() {
		return "registration";
	}
	
	@PostMapping("/user/login")
	public ResponseEntity<HttpStatus> login(@RequestBody Login login, HttpSession session) {
		User user = userService.findByUserName(login.getUserName());
		if(user != null && login.getPassword().equals(user.getPassword())) {
			session.setAttribute("userName", user.getUserName());
			session.setAttribute("userId", user.getId());
			logger.info("session userName: {}, userId: {}",session.getAttribute("userName"),session.getAttribute("userId"));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.UNAUTHORIZED);
	}
	
	
	@PostMapping("/user/registration")
	public  ResponseEntity<HttpStatus> createUser(@RequestBody Registration registration) {
		logger.info("/user/registration {}",registration);
		if(userService.findByUserName(registration.getUserName()) != null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_ACCEPTABLE);
		}
		try {
			registrationService.createNewUser(registration);
		}
		catch(Exception e) {
			logger.error("/user/registration {}",e.getMessage());
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<HttpStatus> deleteUserId(@PathVariable int id, HttpSession session) {
		User user = userService.findById(id);
		logger.info("checking if {} == {}",session.getAttribute("userId"),id);
		if(session.getAttribute("userId").equals((Integer)user.getId())) {
			return new ResponseEntity<HttpStatus>(HttpStatus.UNAUTHORIZED);
		}
		userService.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUserById(Model model, @PathVariable int id, HttpSession session) {
		User user = userService.findById(id);
		logger.info("checking if {} == {}",session.getAttribute("userId"),id);
		if(session.getAttribute("userId").equals((Integer)user.getId())) {
			return new ResponseEntity<User>(user, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping("/user/{id}")
	public ResponseEntity<User> getUserById(Model model, @PathVariable int id, HttpSession session) {
		User user = userService.findById(id);
		logger.info("checking if {} == {}",session.getAttribute("userId"),id);
		if(session.getAttribute("userId").equals((Integer)user.getId())) {
			return new ResponseEntity<User>(user, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping("/user/account")
	public ResponseEntity<Account> getUserById(@RequestParam int userId, HttpSession session) {
		User user = userService.findById(userId);
		logger.info("checking if {} == {}",session.getAttribute("userId"),userId);
		if(session.getAttribute("userId").equals((Integer)user.getId())) {
			return new ResponseEntity<Account>(new Account(), HttpStatus.UNAUTHORIZED);
		}
		Account account = accountService.findById(userId);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	@RequestMapping("/user/show/{id}")
    public String getUserViewById(Model model, @PathVariable int id, HttpSession session) {
        logger.info("Request to /user/{}",id);
        User user = userService.findById(id);
        if(session.getAttribute("userId") == null) {
			return "error";
		}
        model.addAttribute("user", user);
        logger.info("Response {}",user);
        return "user";
    }
}