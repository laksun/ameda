package com.yla.jwi;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class EnvironmentVariableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String user = System.getProperty("user.name");
		System.out.println("Username using system property: " + user);

		// getting username as environment variable in java, only works in windows
		String userWindows = System.getenv("USERNAME");
		System.out.println("Username using environment variable in windows : " + userWindows);

		// name and value of all environment variable in Java program
		Map<String, String> env = System.getenv();
		for (String envName : env.keySet()) {
			System.out.format("%s=%s%n", envName, env.get(envName));
		}

		
		getSystemProperties();
	}
	
	
	public static Properties getSystemProperties() {
		Properties prop = System.getProperties();
		Set<Object> keySet = prop.keySet();
		for (Object obj : keySet) {
			System.out.println("System Property: {" 
					+ obj.toString() + "," 
					+ System.getProperty(obj.toString()) + "}");
		}
		return prop;
	}

}
