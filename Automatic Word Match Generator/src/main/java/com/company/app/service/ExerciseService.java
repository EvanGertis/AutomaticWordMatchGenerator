package com.company.app.service;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.controller.ExerciseController;
import com.company.app.model.Exercise;
import com.company.app.repository.ExerciseRepository;

@Service
public class ExerciseService {
	private static final Logger logger = LogManager.getLogger(ExerciseController.class);

    private final ExerciseRepository exerciseRepository;
    
    @Autowired
    ExerciseService(ExerciseRepository exerciseRepository){
    	this.exerciseRepository = exerciseRepository;
    }
    
    public Exercise save(Exercise exercise) {
    	return exerciseRepository.save(exercise);
    }
    
    public Exercise findById(int id) {
    	return exerciseRepository.findById(id);
    }
    
	public Boolean checkAnswer(int id, int answer) {
		Exercise exercise = exerciseRepository.findById(id);
		return answer==exercise.getAnswer();
	}
	
	public List<Exercise> findAllByChapterId(int chapterId){
		return exerciseRepository.findByChapterId(chapterId);
	}
	
	public Exercise updateById(Exercise exercise, int id) {
		Exercise exerciseToUpdate = exerciseRepository.findById(id);
		exerciseToUpdate.setAnswer(exercise.getAnswer());
		exerciseToUpdate.setChapterId(exercise.getChapterId());
		exerciseToUpdate.setExercise(exercise.getExercise());
		exerciseToUpdate.setHasVisualization(exercise.isHasVisualization());
		exerciseToUpdate.setOne(exercise.getOne());
		exerciseToUpdate.setTwo(exercise.getTwo());
		exerciseToUpdate.setThree(exercise.getThree());
		exerciseRepository.save(exerciseToUpdate);
		return exercise;
	}
	
	public void deleteExerciseById(int id) {
		exerciseRepository.deleteById(id);
	}
}
