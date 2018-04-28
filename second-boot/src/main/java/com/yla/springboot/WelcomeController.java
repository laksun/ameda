package com.yla.springboot;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yla.speech.service.WelcomeService;

@RestController
public class WelcomeController {
	
	int i;
	
	@Autowired
	WelcomeService welcomeService;
	
	@Autowired
	BasicConfiguration basicConfiguration;
	
	@RequestMapping("/welcome")
	public String welcome() {
		//int fdfsdfsd;
		return welcomeService.welcomeMessage();
				
	}
	
	
	@RequestMapping("/basicconfiguration")
	public Map basicConfig() {
		
		return basicConfiguration.getValues();
	}
	

}
