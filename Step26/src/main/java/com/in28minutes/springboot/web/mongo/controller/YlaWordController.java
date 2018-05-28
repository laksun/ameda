package com.in28minutes.springboot.web.mongo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.in28minutes.springboot.web.mongo.model.YLAWord;
import com.in28minutes.springboot.web.mongo.repositories.YlaWordRepository;


@Controller
public class YlaWordController {

	
	@Autowired
	YlaWordRepository  ylaWordRepository;
	
	
	
	@RequestMapping(value="/word/get", method = RequestMethod.GET)
	public String getWord(ModelMap model) {
		model.addAttribute("words", ylaWordRepository.findAll());
		return "word/ylawords";
	}
	
	@RequestMapping("/word/create")
	public String createWord(ModelMap model) {
		return "word/ylawordscreate";
	}
	
	@RequestMapping("/word/save")
	public String saveWord(ModelMap model,@RequestParam String word, @RequestParam String definition, @RequestParam String pos) {
		YLAWord  ylaWord = new YLAWord();
		ylaWord.setDefinition(definition);
		ylaWord.setPos(pos);
		ylaWord.setWord(word);
		ylaWordRepository.save(ylaWord);
		return "redirect:/word/get";
	}
}
