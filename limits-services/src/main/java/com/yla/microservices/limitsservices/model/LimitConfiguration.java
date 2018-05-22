package com.yla.microservices.limitsservices.model;

public class LimitConfiguration {
	
	public LimitConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}


	private int minimum;
	private int maximum;

	
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}


	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}


	public int getMinimum() {
		return minimum;
	}


	public int getMaximum() {
		return maximum;
	}


	public LimitConfiguration(int max, int min) {
		super();
		this.maximum = max;
		this.minimum = min;
	}

}
