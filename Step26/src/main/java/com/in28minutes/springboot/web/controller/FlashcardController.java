package com.in28minutes.springboot.web.controller;

import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.web.model.Flashcard;
import com.in28minutes.springboot.web.model.Todo;
import com.in28minutes.springboot.web.service.FlashcardRepository;

@Controller
public class FlashcardController {
	
	Logger logger = org.slf4j.LoggerFactory.getLogger(FlashcardController.class);

	@Autowired
	FlashcardRepository flashcardRepository;
	
	@RequestMapping(value = "/add-flashcard", method = RequestMethod.GET)
	public String showAddFlashcardPage(ModelMap model) {
		model.addAttribute("flashcard", new Flashcard(0, "Default definition",
				"Default Description","Default word", 0));
		logger.info(" request GET /add-flashcard");
		return "flashcard";
	}

	@RequestMapping(value = "/add-flashcard", method = RequestMethod.POST)
	public String addFlashcard(ModelMap model, @Valid Flashcard flashcard, BindingResult result) {
		if (result.hasErrors()) {
			return "flashcard";
		}

		flashcardRepository.save(flashcard);

		return "redirect:/list-flashcards";

	}
	
	@RequestMapping(value = "/list-flashcards", method = RequestMethod.GET)
	public String showWords(ModelMap model) {
		
		
		model.put("flashcards", flashcardRepository.findAll());
		return "list-flashcards";
	}
}
