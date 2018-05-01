package com.yla.springboot.firstweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yla.springboot.firstweb.service.XLoginService;

@Controller
@SessionAttributes("name")
public class WelcomeController {

//	@Autowired
//	private LoginService service;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		//model.put("name", "yusuf");
		model.put("name", getLoggedinUserName());
		return "welcomeForm";
	}

	private String getLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}
	/*@RequestMapping(value = {"/login","/loginForm","/loginform"}, method = RequestMethod.GET)
	public String loginForm(ModelMap model) {
		return "loginForm";
	}*/

	/*@RequestMapping(value = {"/loginForm","/loginform"}, method = RequestMethod.POST)
	public String welcomeForm(ModelMap model, @RequestParam String name, @RequestParam String password) {

		boolean isValiduser = service.validateUser(name, password);

		if (!isValiduser) {
			model.put("errorMessage", "Invalid Credentials");
			return "loginForm";
		} else {
			model.put("name", name);
			return "welcomeForm";
		}
	}*/
}
