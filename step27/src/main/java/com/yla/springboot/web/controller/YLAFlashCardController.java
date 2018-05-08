package com.yla.springboot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yla.springboot.web.model.YLAFlashCard;
import com.yla.springboot.web.service.YLAFlashCardRepository;

@RestController
public class YLAFlashCardController {
	
	@Autowired
	YLAFlashCardRepository  flashCardRepository;
	
	//first method to add
	
	@RequestMapping(value="/addFlashCard", method=RequestMethod.POST)
	public String addFlashCard(ModelMap model, @Valid  YLAFlashCard flashCard, BindingResult result) {
		if (result.hasErrors()) {
			return "ylaflashCard";
		}
		
		flashCardRepository.save(flashCard);
		return "ylaflashCard";
	}
	
	
	

}
