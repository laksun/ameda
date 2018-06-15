package com.yla.datamuse.berlinuhr;

import java.time.Duration;

public class TopLamp {
	//even seconds blink on
	//odd seconds blink off 
	
	Duration second = Duration.ofSeconds(0);
	
	
	
	public Duration getSecond() {
		return second;
	}


	public void setSecond(Duration second) {
		this.second = second;
	}


	public TopLamp() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public TopLamp(Duration second) {
		super();
		this.second = second;
		if (    second.getSeconds() % 2 == 0)
		   this.blink = true;
	}


	public TopLamp(int i) {
		int seconds = i % 60;
		this.second = Duration.ofSeconds(seconds, 0);
	}


	boolean blink;

	public boolean isBlink() {
		return blink;
	}

	public void setBlink(boolean b) {
		this.blink= b;
		
	}

}
