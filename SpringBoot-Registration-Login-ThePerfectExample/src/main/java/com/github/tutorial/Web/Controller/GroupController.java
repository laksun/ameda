package com.github.tutorial.Web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GroupController {
	
	@RequestMapping(value = {"/group"}, method= RequestMethod.GET)
	public ModelAndView group() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("group");
		return modelAndView;
	}

}
