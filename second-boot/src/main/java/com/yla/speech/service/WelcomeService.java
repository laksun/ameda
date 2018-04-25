package com.yla.speech.service;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class WelcomeService {
	
	public String welcomeMessage() {
		return "Hello today is " + (new Date()).toString();
	}

}
