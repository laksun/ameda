package com.yla.springboot.mockito;

import static org.junit.Assert.*;

import org.junit.Test;

public class SomeBusinessTest {

	@Test
	public void testFindGreatestNumber() {
		SomeBusinessImpl sbi = new SomeBusinessImpl(new DataServiceStub()); 
		int result = sbi.findGreatestNumber();
		assertEquals(24, result);
	}

}
