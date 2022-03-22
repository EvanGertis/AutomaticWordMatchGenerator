package com.company.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.app.model.Chapter;

@Repository
public interface ChapterRepository extends CrudRepository<Chapter, Integer> {
	Chapter findById(int id);
	List<Chapter> findByBookId(int bookId);
}
