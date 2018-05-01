package com.yla.springboot.firstweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

	 @RequestMapping("/register")
	 public String register(@RequestParam String registerid, ModelMap model) {
		 model.put("registerid", registerid);
		 return "register";
	 }
}
