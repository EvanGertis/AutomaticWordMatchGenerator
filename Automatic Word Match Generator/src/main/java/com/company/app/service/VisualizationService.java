package com.company.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.model.Visualization;
import com.company.app.repository.VisualizationRepository;

@Service
public class VisualizationService {
	
	private VisualizationRepository visualizationRepository;
	
	@Autowired
	VisualizationService(VisualizationRepository visualizationRepository){
		this.visualizationRepository = visualizationRepository;
	}
	
	public Visualization save(Visualization visualization) {
		return visualizationRepository.save(visualization);
	}
	
	public void deleteById(int id) {
		visualizationRepository.deleteById(id);
	}
	
	public Visualization updateVisualizationById(Visualization visualization, int id) {
		Visualization visualizationToUpdate = visualizationRepository.findById(id);
		visualizationToUpdate.setVisualization(visualization.getVisualization());
		visualizationToUpdate = visualizationRepository.save(visualizationToUpdate);
		return visualizationToUpdate;
	}
	
	public Visualization findById(int id) {
		return visualizationRepository.findById(id);
	}
	
	public Visualization findByExerciseId(int exerciseId) {
		return visualizationRepository.findByExerciseId(exerciseId);
	}

}
