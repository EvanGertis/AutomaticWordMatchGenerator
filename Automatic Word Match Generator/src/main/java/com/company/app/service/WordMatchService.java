package com.company.app.service;

/*
 * WordMatchService.java
 * Author: Evan Gertis
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.app.model.WordMatch;
import java.io.File;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.util.Base64;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

import com.company.app.model.WordMatch;
import com.company.app.repository.WordMatchRepository;


@Service
public class WordMatchService {
	private static final Logger logger =  LogManager.getLogger(WordMatchService.class);
	private WordMatchRepository wordMatchRepository;
	
	@Autowired
	WordMatchService(WordMatchRepository wordMatchRepository){
		this.wordMatchRepository = wordMatchRepository;
	}
	
	public WordMatch save(WordMatch wordMatch) {
		return wordMatchRepository.save(wordMatch);
	}
	
	public void deleteById(int id) {
		wordMatchRepository.deleteById(id);
	}
	
	public WordMatch updateWordMatchById(WordMatch wordMatch, int id) {
		WordMatch wordMatchToUpdate = wordMatchRepository.findById(id);
		wordMatchToUpdate.setContent(wordMatch.getContent());
		wordMatchToUpdate = wordMatchRepository.save(wordMatchToUpdate);
		return wordMatchToUpdate;
	}
	
	public WordMatch findById(int id) {
		return wordMatchRepository.findById(id);
	}
	
	public WordMatch findByWordMatchId(int wordMatchId) {
		return wordMatchRepository.findByWordMatchId(wordMatchId);
	}
	

	public Long saveJSP(WordMatch wordMatch){
		logger.info(wordMatch);
		Long numberOfFiles = (long) 0;
		try {
			File file = new File("./src/main/webapp/view/word_match0.jsp");
			logger.info("Decoding String");
			// String cleanedHTML = wordMatch.toString().replace("WordMatch(content=","").replace(")","");
			String cleanedHTML = wordMatch.getContent().toString();
			logger.info(cleanedHTML);
			byte[] decodedBytes = Base64.getDecoder().decode(cleanedHTML.getBytes());
			String html = new String(decodedBytes, "UTF-8");
			logger.info(html);
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
				try {
					FileWriter myWriter = new FileWriter("./src/main/webapp/view/word_match0.jsp");
					myWriter.write(html);
					myWriter.close();
				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			} else {
				String fileName = file.getName().toString();
				String index = fileName.substring(fileName.indexOf("h") + 1);
				index = index.substring(0, index.indexOf("."));
				Integer parsedInt = Integer.parseInt(index);
				System.out.println(parsedInt);
				Stream<Path> files = Files.list(Paths.get("./src/main/webapp/view/"));
				numberOfFiles = files.map(Path.class::cast)
				                          .filter(path -> path.getFileName().toString().startsWith("word_match"))
				                          .count();
				fileName = fileName.replace(index,numberOfFiles.toString());
				System.out.println(numberOfFiles);
				System.out.println("fileName should have been printed by now");
				file = new File(fileName);
				String JSPfileName = "./src/main/webapp/view/"+file;
				FileWriter myWriter = new FileWriter(JSPfileName);
				// Saving wordMatch to database
				wordMatch.setId(parsedInt);
				// TODO: fix  Data truncation: Data too long for column 'content' at row 1
				// wordMatchRepository.save(wordMatch);
				// 
				myWriter.write(html);
				myWriter.close();
				// Write JSP file to HTML
				// File path is passed as parameter
				File jspFile = new File(JSPfileName);
				
				// Note:  Double backquote is to avoid compiler
				// interpret words
				// like \test as \t (ie. as a escape sequence)
				
				// Creating an object of BufferedReader class
				BufferedReader br
				= new BufferedReader(new FileReader(jspFile));
				
				// Declaring a string variable
				String st;
				// Condition holds true till
				// there is character in a string
				String htmlFileName = JSPfileName.replace("jsp","html");
				File htmlFile = new File(htmlFileName);
				String content = "Writing To File";
				if (!htmlFile.exists()) {
					htmlFile.createNewFile();
				} 
				try {
					FileWriter fw = new FileWriter(htmlFile.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					while ((st = br.readLine()) != null) {
						System.out.println(st);
						bw.write(st);
				}
				bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Done");	
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return numberOfFiles;
	}

	public void JSPtoHTML(String fileNameForJSP) throws Exception {
		// File path is passed as parameter
		File file = new File(fileNameForJSP);
		
		// Note:  Double backquote is to avoid compiler
		// interpret words
		// like \test as \t (ie. as a escape sequence)
		
		// Creating an object of BufferedReader class
		BufferedReader br
		= new BufferedReader(new FileReader(file));
		
		// Declaring a string variable
		String st;
		// Condition holds true till
		// there is character in a string
		String htmlFileName = fileNameForJSP.replace("jsp","html");
		File htmlFile = new File(htmlFileName);
		String content = "Writing To File";
		if (!htmlFile.exists()) {
			htmlFile.createNewFile();
		} 
		try {
			FileWriter fw = new FileWriter(htmlFile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			while ((st = br.readLine()) != null) {
				System.out.println(st);
				bw.write(st);
		}
		bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}

	public Long saveHTML(WordMatch wordMatch){
		logger.info(wordMatch);
		Long numberOfFiles = (long) 0;
		try {
			File file = new File("./src/main/webapp/view/word_match0.html");
			logger.info("Decoding String");
			String cleanedHTML = wordMatch.toString().replace("WordMatch(content=","").replace(")","");
			logger.info(cleanedHTML);
			byte[] decodedBytes = Base64.getDecoder().decode(cleanedHTML.getBytes());
			String html = new String(decodedBytes, "UTF-8");
			logger.info(html);
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
				try {
					FileWriter myWriter = new FileWriter("./src/main/webapp/view/word_match0.html");
					myWriter.write(html);
					myWriter.close();
				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			} else {
				String fileName = file.getName().toString();
				String index = fileName.substring(fileName.indexOf("h") + 1);
				index = index.substring(0, index.indexOf("."));
				Integer parsedInt = Integer.parseInt(index);
				System.out.println(parsedInt);
				Stream<Path> files = Files.list(Paths.get("./src/main/webapp/view/"));
				numberOfFiles = files.map(Path.class::cast)
				                          .filter(path -> path.getFileName().toString().startsWith("word_match"))
				                          .count();
				fileName = fileName.replace(index,numberOfFiles.toString());
				System.out.println(numberOfFiles);
				System.out.println("fileName should have been printed by now");
				file = new File(fileName);
				FileWriter myWriter = new FileWriter("./src/main/webapp/view/"+file);
				myWriter.write(html);
				myWriter.close();
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return numberOfFiles;
	}
}
