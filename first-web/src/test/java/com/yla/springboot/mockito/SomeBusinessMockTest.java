package com.yla.springboot.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {
	@Mock
	DataService dataServiceMock;

	@InjectMocks
	SomeBusinessImpl sbi;

	@Test
	public void testFindGreatestNumber() {
		// DataService dataServiceMock = mock(DataService.class);

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 24, 5, 6 });

		// SomeBusinessImpl sbi = new SomeBusinessImpl(dataServiceMock);
		assertEquals(24, sbi.findGreatestNumber());
	}

	@Test
	public void testFindGreatestNumber_foronevalue() {
		// DataService dataServiceMock = mock(DataService.class);

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 15 });

		// SomeBusinessImpl sbi = new SomeBusinessImpl(dataServiceMock);
		assertEquals(15, sbi.findGreatestNumber());
	}
	
	@Test
	public void testFindGreatestNumber_forNovalue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {  });
		assertEquals(Integer.MIN_VALUE, sbi.findGreatestNumber());
	}

}
