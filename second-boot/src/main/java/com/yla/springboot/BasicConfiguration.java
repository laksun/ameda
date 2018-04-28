package com.yla.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;

@Controller
@ConfigurationProperties("basic")
public class BasicConfiguration {
  
	 boolean value;
	 String message;
	 int number;
	public boolean isValue() {
		return value;
	}
	public void setValue(boolean value) {
		this.value = value;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Map getValues() {
		Map map = new HashMap();
		map.put("message", this.message);
		map.put("number", this.number);
		map.put("value", this.value);
		return map;
	}
	 
}
