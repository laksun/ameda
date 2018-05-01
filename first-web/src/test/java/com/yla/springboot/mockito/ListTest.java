package com.yla.springboot.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class ListTest {

	@Test
	public void test() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(10);

		assertEquals(10, listMock.size());
	}

	@Test
	public void test_multipleReturns() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(10).thenReturn(20);

		assertEquals(10, listMock.size());
		assertEquals(20, listMock.size());
		assertEquals(20, listMock.size());
	}

	@Test
	public void test_parameter() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("Some string");

		assertEquals("Some string", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}

	
	@Test
	public void test_anyParameter() {
		List listMock = mock(List.class);
		when(listMock.get(Mockito.anyInt())).thenReturn("Some string");

		assertEquals("Some string", listMock.get(0));
		assertEquals("Some string", listMock.get(1));
	}
}
