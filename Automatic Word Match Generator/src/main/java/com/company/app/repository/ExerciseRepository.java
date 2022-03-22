package com.company.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.app.model.Exercise;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Integer> {
	Exercise findById(int id);
	List<Exercise> findByChapterId(int chapterId);
}
