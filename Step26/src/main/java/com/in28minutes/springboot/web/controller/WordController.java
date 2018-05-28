package com.in28minutes.springboot.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.web.model.Ylaword;
import com.in28minutes.springboot.web.service.YlaWordRepository;

@RestController
public class WordController {

	Logger logger = LoggerFactory.getLogger(WordController.class);

	//@Autowired
	
	private YlaWordRepository ylaWordRepository;
	
	

	@GetMapping("/ylaword/getword/{id}")
	public Ylaword getYlaWord(@PathVariable int id) {
		Ylaword ylaWord = ylaWordRepository.findOne(id);
		logger.info(ylaWord.toString());
		return ylaWord;
	}
	
	
}
