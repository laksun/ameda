package com.yla.springboot.firstweb.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class User {

	String name ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
