package com.company.app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.company.app.model.Chapter;
import com.company.app.repository.ChapterRepository;
import com.company.app.service.ChapterService;

public class ChapterServiceTest {
	@Mock
	ChapterRepository chapterRepository;
	
	@InjectMocks
	ChapterService chapterService;
	
	@BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void checkCreateAccount() {
		Chapter chapter = new Chapter();
		chapter.setId(1);
		chapter.setBookId(1);
		chapter.setTitle("How to program");
		when(chapterRepository.save(ArgumentMatchers.any())).thenReturn(chapter);
		Chapter createdChapter = chapterService.save(chapter);
		assertEquals(createdChapter,chapter);
	}

}
