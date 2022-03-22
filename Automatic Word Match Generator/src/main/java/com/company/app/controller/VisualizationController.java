package com.company.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.app.model.Visualization;
import com.company.app.service.VisualizationService;

@Controller
public class VisualizationController {
	
	private static final Logger logger = LogManager.getLogger(UserController.class);
	private final VisualizationService visualizationService;
	
	@Autowired
	public VisualizationController(VisualizationService visualizationService) {
		this.visualizationService = visualizationService;
	}
	
	@PutMapping("/visualization/{id}")
    public ResponseEntity<Visualization> updateVisualizationById(@RequestBody Visualization visualization,@PathVariable int id){
		logger.info("PUT Request to /visualization/{} Visualization: {}",visualization,id);
		visualization = visualizationService.updateVisualizationById(visualization, id);
    	return new ResponseEntity<Visualization>(visualization, HttpStatus.ACCEPTED);
    }
	
	@RequestMapping("/visualization/{id}")
    public ResponseEntity<Visualization> getVisualizationById(@PathVariable int id) {
        Visualization visualization = visualizationService.findById(id);
        return new ResponseEntity<Visualization>(visualization, HttpStatus.OK);
    }
	
	@RequestMapping("/visualization/show/{exerciseId}")
    public String getVisualizationViewById(Model model, @PathVariable int exerciseId) {
    	logger.info("Request to /visualization/{}",exerciseId);
    	Visualization visualization = visualizationService.findByExerciseId(exerciseId);
    	model.addAttribute("visualization", visualization);
    	logger.info("Response {}", visualization);
    	return "visualization";
    }
}
