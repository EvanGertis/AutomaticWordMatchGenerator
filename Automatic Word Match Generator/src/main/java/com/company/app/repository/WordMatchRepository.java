package com.company.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.app.model.WordMatch;

@Repository
public interface WordMatchRepository extends CrudRepository<WordMatch, Integer> {
	WordMatch findById(int id);
	WordMatch findByWordMatchId(int wordMatchId);
}
