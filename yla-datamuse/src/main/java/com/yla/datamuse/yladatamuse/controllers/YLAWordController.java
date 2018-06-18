package com.yla.datamuse.yladatamuse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yla.datamuse.yladatamuse.models.YLAWords;
import com.yla.datamuse.yladatamuse.repositories.YLAWordRepository;


@Controller
public class YLAWordController {
	
	@Autowired
	YLAWordRepository  ylaWordRepository;
	
	@RequestMapping("/cylawords")
	public String ylawords(Model model) {
		model.addAttribute("ylawords", ylaWordRepository.findAll());
		return("ylawords");
	}
	
	@RequestMapping("saveylawords")
	public String save(@RequestParam String wordName, @RequestParam String wordMeaning, @RequestParam String wordExample) {
		YLAWords  ylaWords = new    YLAWords();
		ylaWords.setWordName(wordName);
		ylaWords.setWordMeaning(wordMeaning);
		ylaWords.setWordExample(wordExample);
		ylaWordRepository.save(ylaWords);
		
		return "redirect:/cylawords";
		
	}
	
	@RequestMapping("createylaword")
	public String create() {
		return "ylacreateword";
	}
	

}
