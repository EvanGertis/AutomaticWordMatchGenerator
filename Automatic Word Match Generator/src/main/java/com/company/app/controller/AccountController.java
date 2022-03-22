package com.company.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.app.model.Account;
import com.company.app.model.Book;
import com.company.app.service.AccountService;
import com.company.app.service.BookService;


@Controller
public class AccountController {
	private static final Logger logger = LogManager.getLogger(AccountController.class);
	private final AccountService accountService;
	private final BookService bookService;
	
	@Autowired
	public AccountController(AccountService accountService, BookService bookService) {
		this.accountService = accountService;
		this.bookService = bookService;
	}
	
	@PostMapping("/account")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		account = accountService.save(account);
		return new ResponseEntity<Account>(account, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/account/{id}")
	public ResponseEntity<HttpStatus> deleteAccountById(@PathVariable int id, HttpSession session) {
		Account account = accountService.findById(id);
		logger.info("checking if {} == {}",session.getAttribute("userId"),account.getUserId());
		if(!session.getAttribute("userId").equals((Integer)account.getUserId())) {
			return new ResponseEntity<HttpStatus>(HttpStatus.UNAUTHORIZED);
		}
		accountService.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping("/account/{id}")
	public ResponseEntity<Account> updateAccountById(@RequestBody Account account, @PathVariable int id) {
		account = accountService.updateAccount(account, id);
		return new ResponseEntity<Account>(account, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping("/account/{id}")
	public ResponseEntity<Account> getAccountById(Model model, @PathVariable int id, HttpSession session) {
		Account account = accountService.findById(id);
		logger.info("checking if {} == {}",session.getAttribute("userId"),account.getUserId());
		if(!session.getAttribute("userId").equals((Integer)account.getUserId())) {
			return new ResponseEntity<Account>(new Account(),HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	@RequestMapping("/account/books")
	public ResponseEntity<List<Book>> getBooksByAccountId(@RequestParam int accountId, HttpSession session) {
		Account account = accountService.findById(accountId);
		logger.info("checking if {} == {}",session.getAttribute("userId"),account.getUserId());
		if(!session.getAttribute("userId").equals((Integer)account.getUserId())) {
			return new ResponseEntity<List<Book>>(new ArrayList<>(),HttpStatus.UNAUTHORIZED);
		}
		List<Book> books = bookService.findByAllByAccountId(accountId);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	@RequestMapping("/account/showByUserId/{id}")
    public String getAccountViewByUserId(Model model, @PathVariable int id, HttpSession session) {
		Account account = accountService.findByUserId(id);
		logger.info("checking if {} == {}",session.getAttribute("userId"),account.getUserId());
		if(!session.getAttribute("userId").equals((Integer)account.getUserId())) {
			return "error";
		}
        logger.info("Request to /account/showByUserId/{}",id);
        model.addAttribute("account", account);
        logger.info("Response {}",account);
        return "account";
    }
	
	@RequestMapping("/account/show/{id}")
    public String getAccountViewById(Model model, @PathVariable int id, HttpSession session) {
        logger.info("Request to /account/{}",id);
        Account account = accountService.findById(id);
        logger.info("checking if {} == {}",session.getAttribute("userId"),account.getUserId());
		if(!session.getAttribute("userId").equals((Integer)account.getUserId())) {
			return "error";
		}
        model.addAttribute("account", account);
        logger.info("Response {}",account);
        return "account";
    }
}