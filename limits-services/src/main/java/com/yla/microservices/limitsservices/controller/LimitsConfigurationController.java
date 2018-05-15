package com.yla.microservices.limitsservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yla.microservices.limitsservices.Configuration;
import com.yla.microservices.limitsservices.model.LimitConfiguration;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitConfiguration  retrieveLimits() {
		return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
	}
}
