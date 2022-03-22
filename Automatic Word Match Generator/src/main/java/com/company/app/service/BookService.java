package com.company.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.model.Book;
import com.company.app.repository.BookRepository;

@Service
public class BookService {
	
	private BookRepository bookRepository;
	
	@Autowired
	BookService(BookRepository bookRepository){
		this.bookRepository = bookRepository;
	}
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	public Book findById(int id) {
		return bookRepository.findById(id);
	}
	
	public List<Book> findByAllByAccountId(int accountId) {
		return bookRepository.findByAccountId(accountId);
	}
	
	public void deleteById(int id) {
		bookRepository.deleteById(id);
	}
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	public Book updateBookById(Book book, int id) {
		Book bookToUpdate = bookRepository.findById(id);
		bookToUpdate.setAuthor(book.getAuthor());
		bookToUpdate.setTitle(book.getAuthor());
		bookToUpdate = bookRepository.save(book);
		return bookToUpdate;
	}
	

}
