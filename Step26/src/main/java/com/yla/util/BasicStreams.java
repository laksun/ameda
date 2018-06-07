package com.yla.util;

import java.util.List;

import com.yla.springboot.web.mongo.model.Employee;

import java.util.Arrays;
import static java.util.stream.Collectors.toList;

public class BasicStreams {
	static List<Employee> employeeList = Arrays.asList(new Employee("Tom Jones", 45), new Employee("Harry Major", 25),
			new Employee("Ethan Hardy", 65), new Employee("Nancy Smith", 15), new Employee("Deborah Sprightly", 29));

	public static void main(String args[]) {
		
		List<Employee> filteredList = employeeList.stream().limit(2).collect(toList());
		
		filteredList.forEach(System.out::println);

	}
}