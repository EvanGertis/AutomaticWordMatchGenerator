package com.company.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.app.model.Visualization;

@Repository
public interface VisualizationRepository extends CrudRepository<Visualization, Integer> {
	Visualization findById(int id);
	Visualization findByExerciseId(int exerciseId);
}
