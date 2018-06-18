package com.yla.datamuse.yladatamuse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	

}
