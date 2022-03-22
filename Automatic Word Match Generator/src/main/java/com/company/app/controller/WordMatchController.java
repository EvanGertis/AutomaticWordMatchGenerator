package com.company.app.controller;

//WordMatchController.java
//Author: Evan Gertis 10/11/2021

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.app.model.View;
import com.company.app.model.WordMatch;
import com.company.app.service.WordMatchService;

@Controller
public class WordMatchController {
	private static final Logger logger =  LogManager.getLogger(WordMatchController.class);
	private final WordMatchService wordMatchService;
	
	@Autowired
	public WordMatchController(WordMatchService wordMatchService) {
		logger.info("visiting word match");
		this.wordMatchService = wordMatchService;
	}
	
	@PostMapping("/wordmatchgenerator")
	public ResponseEntity<View> saveWordMatchJSP(@RequestBody WordMatch wordMatch) {
		logger.info("Processing word match from client");
		logger.info(wordMatch);
		Long Id = wordMatchService.saveJSP(wordMatch);
        View view = new View();
        logger.info("New view created with id {}",Id);
        logger.info("View object before {}",view);
        view.setId(Id);
        logger.info("View object after {}",view);
		return new ResponseEntity<View>(view, HttpStatus.CREATED);
	}

	@RequestMapping("/wordmatchgenerator/{id}")
    public String getWordMatch(@PathVariable String id ,Model model) {
        return "word_match"+id;
    }

	@RequestMapping("/wordmatchgenerator")
	public String getWordMAtch(Model model){
		return "word_match";
	}

}