package com.company.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.app.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
	Book findById(int id);
	List<Book> findByAccountId(int accountId);
	List<Book> findAll();
}
