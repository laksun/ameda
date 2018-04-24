package com.yla.springboot.mockito;

public class DataServiceStub implements DataService {

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {24, 6, 15};
	}

}
