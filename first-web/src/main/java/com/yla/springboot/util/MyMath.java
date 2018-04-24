package com.yla.springboot.util;

public class MyMath {

	public int sum(int[] numberArray) {
		// TODO Auto-generated method stub
		int result =0;
		for (int item:numberArray) {
			result += item;
		}
		return result;
	}

}
