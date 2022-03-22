package com.company.app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.company.app.model.Exercise;
import com.company.app.repository.ExerciseRepository;
import com.company.app.service.ExerciseService;

public class ExerciseServiceTest {
	@Mock
	ExerciseRepository exerciseRepository;
	
	@InjectMocks
	ExerciseService exerciseService;
	
	@BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void checkCreateAccount() {
		Exercise exercise = new Exercise();
		exercise.setId(1);
		exercise.setChapterId(1);
		exercise.setExercise("HelloWorld.txt");
		exercise.setOne("Hello World");
		exercise.setTwo("Hello");
		exercise.setThree("Hello Wor");
		exercise.setQuestion("What will be the output of this program?");
		when(exerciseRepository.save(ArgumentMatchers.any())).thenReturn(exercise);
		Exercise createdExercise = exerciseService.save(exercise);
		assertEquals(createdExercise,exercise);
	}
}
