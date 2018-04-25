package com.yla.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yla.speech.service.WelcomeService;

@RestController
public class WelcomeController {
	
	@Autowired
	WelcomeService welcomeService;
	
	@RequestMapping("/welcome")
	public String welcome() {
		return welcomeService.welcomeMessage();
				
	}
	
	

}
