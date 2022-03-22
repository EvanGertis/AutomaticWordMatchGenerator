package com.company.app.controller;

import java.util.List;

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

import com.company.app.model.Book;
import com.company.app.model.Chapter;
import com.company.app.service.BookService;
import com.company.app.service.ChapterService;

@Controller
public class BookController {
    private static final Logger logger = LogManager.getLogger(BookController.class);
    private final BookService bookService;
    private final ChapterService chapterService;

    @Autowired
    public BookController(BookService bookService, ChapterService chapterService) {
        this.bookService = bookService;
        this.chapterService = chapterService;
    }
    
    @RequestMapping("/books/")
    public ResponseEntity<List<Book>> getBooks(){
    	List<Book> books = bookService.findAll();
    	return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
    
    @PostMapping("/books/")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
    	book = bookService.save(book);
    	return new ResponseEntity<Book>(book, HttpStatus.CREATED);
    }
    

    @DeleteMapping("/books/{id}")
    public HttpStatus deleteBookById(@PathVariable int id) {
    	bookService.deleteById(id);
    	return HttpStatus.ACCEPTED;
    }
    
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBookById(Book book, int id){
    	book = bookService.updateBookById(book, id);
    	return new ResponseEntity<Book>(book, HttpStatus.ACCEPTED);
    }
    
    @RequestMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id){
    	Book book = bookService.findById(id);
    	return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
    
    @RequestMapping("/books/chapters")
	public ResponseEntity<List<Chapter>> getChaptersById(@RequestParam int bookId) {
		List<Chapter> chapter = chapterService.findAllById(bookId);
		return new ResponseEntity<List<Chapter>>(chapter, HttpStatus.OK);
	}
    
    @RequestMapping("/books/show/{id}")
    public String getBookViewById(Model model, @PathVariable int id) {
    	logger.info("Request to /books/{}",id);
    	Book book = bookService.findById(id);
    	model.addAttribute("book", book);
    	logger.info("Response {}", book);
    	return "book";
    }
}
