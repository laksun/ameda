package com.yla.datamuse.berlinuhr;

import java.time.Clock;


import java.time.Duration;


//https://github.com/vfarcic/TechnologyConversationsJava/blob/master/src/main/java/com/technologyconversations/learning/kata/solutions/BerlinClock.java


//https://technologyconversations.com/2014/02/25/java-8-tutorial-through-katas-berlin-clock-easy/

public class Uhr {
	
	Seconds seconds = new Seconds();
	Minutes minutes = new Minutes();
	Hours hours = new Hours();
	public Seconds getSeconds() {
		return seconds;
	}
	public void setSeconds(Seconds seconds) {
		this.seconds = seconds;
	}
	public Minutes getMinutes() {
		return minutes;
	}
	public void setMinutes(Minutes minutes) {
		this.minutes = minutes;
	}
	public Hours getHours() {
		return hours;
	}
	public void setHours(Hours hours) {
		this.hours = hours;
	}
	
	
	TopLamp topLamp = new TopLamp();
	public TopLamp getTopLamp() {
		return topLamp;
	}
	public void setTopLamp(TopLamp topLamp) {
		this.topLamp = topLamp;
	}
	public void tick() {
		//increment the second by 1
		long currentSecond= seconds.getSecond().getSeconds();
		seconds.setSecond(seconds.tick());
		// change the seconds, minutes, hours accordingly
		
	}
	public Uhr() {
		super();
		// TODO Auto-generated constructor stub		
		Clock c = Clock.systemUTC(); 
	}
	
	public Uhr(long seconds, long minutes, long hours) {
		super();
		this.seconds.setSecond( Duration.ofSeconds(seconds)) ;
		
	}
	
	
	

}
