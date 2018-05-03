package com.yla.springboot.firstweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {



	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String showWelcomePage(HttpServletRequest request, HttpServletResponse response) {
		
		return "redirect:/login";
	}

	
}
