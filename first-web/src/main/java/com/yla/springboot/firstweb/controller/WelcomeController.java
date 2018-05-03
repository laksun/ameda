package com.yla.springboot.firstweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.yla.springboot.firstweb.model.User;
import com.yla.springboot.firstweb.service.XLoginService;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	@Autowired
	private XLoginService service;
	

	
	@RequestMapping(value = {"/","/login","/loginForm","/loginform"}, method = RequestMethod.GET)
	public String loginForm(ModelMap model) {
		return "loginForm";
	}

	@RequestMapping(value = {"login","/","/loginForm","/loginform"}, method = RequestMethod.POST)
	public ModelAndView welcomeForm(ModelMap model, @RequestParam String name, @RequestParam String password) {

		boolean isValiduser = service.validateUser(name, password);

		if (!isValiduser) {
			model.put("errorMessage", "Invalid Credentials");
			return new ModelAndView("loginForm",model);
		} else {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("welcomeForm");
			modelAndView.addObject("name",name);
			model.put("name", name);
			
			return  modelAndView;
		}
	}
}
