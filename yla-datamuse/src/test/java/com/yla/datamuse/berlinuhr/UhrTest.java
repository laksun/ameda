package com.yla.datamuse.berlinuhr;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.Test;

public class UhrTest {

	@Test 
	public void tickSecondTest(){
		
		//every tick should increment the time by 1 second
		Uhr uhr = new Uhr();
		Duration  seconds = uhr.getTopLamp().getSecond();
		long secondsValue = seconds.getSeconds();
		
		uhr.tick();
		
		assertEquals(secondsValue+1, uhr.getTopLamp().getSecond().getSeconds());
		
		
		
		
	}
}
