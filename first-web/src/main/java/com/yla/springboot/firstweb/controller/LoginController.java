package com.yla.springboot.firstweb.controller;

public class LoginController {

	public boolean login(String userName, String password) {
		if (userName.equals("yusuf") && password.equals("12345678"))
		{
			return true;
		}
		return false;
	}

}
