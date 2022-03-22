package com.company.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="visualization")
@Data
public class Visualization {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    
    private String visualization;
    
    private int exerciseId;

	public String getVisualization() {
		return visualization;
	}

	public void setVisualization(String visualization) {
		this.visualization = visualization;
	}

	public int getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}
}
