package com.yla.speech.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WelcomeService {
	
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	public String welcomeMessage() {
		return welcomeMessage;
				//"Hello today is " + (new Date()).toString();
	}

}
