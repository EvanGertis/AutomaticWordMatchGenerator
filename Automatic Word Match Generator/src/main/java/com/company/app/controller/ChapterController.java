package com.company.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.app.model.Chapter;
import com.company.app.service.ChapterService;

@Controller
public class ChapterController {
	private static final Logger logger = LogManager.getLogger(ChapterController.class);
	private final ChapterService chapterService;
	
	@Autowired
	public ChapterController(ChapterService chapterService) {
		this.chapterService = chapterService;
	}
	
	@PostMapping("/chapter")
	public ResponseEntity<Chapter> createChapter(@RequestBody Chapter chapter) {
		chapter = chapterService.save(chapter);
		return new ResponseEntity<Chapter>(chapter, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/chapter/{id}")
	public HttpStatus deleteChapterId(@PathVariable int id) {
		chapterService.deleteById(id);
		return HttpStatus.ACCEPTED;
	}
	
	@PutMapping("/chapter/{id}")
	public ResponseEntity<Chapter> updateChapterById(@RequestBody Chapter chapter, @PathVariable int id) {
		chapter = chapterService.updateChapterById(chapter, id);
		return new ResponseEntity<Chapter>(chapter, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping("/chapter/{id}")
	public ResponseEntity<Chapter> getChapterById(Model model, @PathVariable int id) {
		Chapter chapter = chapterService.findById(id);
		return new ResponseEntity<Chapter>(chapter, HttpStatus.OK);
	}
	
	@RequestMapping("/chapter/show/{id}")
    public String getChapterViewById(Model model, @PathVariable int id) {
        logger.info("Request to /chapter/{}",id);
        Chapter chapter = chapterService.findById(id);
        model.addAttribute("chapter", chapter);
        logger.info("Response {}",chapter);
        return "chapter";
    }
}