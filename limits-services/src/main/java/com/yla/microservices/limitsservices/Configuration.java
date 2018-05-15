package com.yla.microservices.limitsservices;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-services")
public class Configuration {

	private int minimum;
	private int maximum;
	
	
	public int getMinimum() {
		// TODO Auto-generated method stub
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMaximum() {
		// TODO Auto-generated method stub
		return maximum;
	}

	
	
}
