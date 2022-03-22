package com.company.app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.company.app.model.Book;
import com.company.app.repository.BookRepository;
import com.company.app.service.BookService;

public class BookServiceTest {
	@Mock
	BookRepository bookRepository;
	
	@InjectMocks
	BookService bookService;
	
	@BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void checkCreateAccount() {
		Book book = new Book();
		book.setId(1);
		book.setAccountId(1);
		book.setAuthor("John Doe");
		book.setTitle("How to program");
		when(bookRepository.save(ArgumentMatchers.any())).thenReturn(book);
		Book createdBook = bookService.save(book);
		assertEquals(createdBook,book);
	}
}
