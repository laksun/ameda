package com.yla.datamuse.berlinuhr;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.Test;

public class TopLampTest {
	
	@Test
	public void blinkTest() {
		TopLamp topLamp = new TopLamp(Duration.ofSeconds(0));
		
		
		assertEquals(true, topLamp.isBlink());
	}

}
