package com.yla.springboot.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyMathTest {

	private MyMath mymath = new MyMath();
	
	@BeforeClass
	public static void runBeforeClass() {
		System.out.println("runs before class");
	}
	
	@AfterClass
	public static void runAfterClass() {
		System.out.println("runs after class");
	}
	
	@Before
	public void runBeforeEachMethod() {
		System.out.println("befor test method");
	}

	
	@After
	public void runAfterEachMethod() {
		System.out.println("after test method");
	}
	
	
	@Test
	public void sum_with3Numbers() {
		System.out.println(" test sum_with3Numbers");
		assertEquals(6,mymath.sum(new int[] {1,2,3}));
	}
	
	@Test
	public void sum_with2Numbers() {
		System.out.println(" test methsum_with2Numbersod");
		assertEquals(3,mymath.sum(new int[] {1,2}));
	}

}
