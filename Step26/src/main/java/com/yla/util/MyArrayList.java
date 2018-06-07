package com.yla.util;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.yla.springboot.web.mongo.model.Employee;


public class MyArrayList {
	
	static List<Employee> employeeList = new ArrayList<>();

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Word1", "Word2");
		
		List<String> questionList = Arrays.asList("q1","q2");
		
		list.forEach(System.out::println);
		
		List<Integer> list3 = Arrays.asList(2,1,4,6,4,313,6);
		
		for (Integer i : list3) {
			System.out.println(i);
		}
		
		list3.sort(null);
		list3.forEach(System.out::println);
		
		System.out.println("Sorting with a method references");
        List<String> l3 = createList();
        //l3.sort(String::compareToIgnoreCase);
        //l3.sort(null);
        l3.sort((s1,s2)->s1.compareToIgnoreCase(s2));
        l3.forEach(System.out::println);
        
     //   l3.removeIf(s -> s.toLowerCase().contains("x"));
        l3.forEach(System.out::println);
        
        
        employeeList.add(new Employee("Tom Jones", 45, 7000.00));
        employeeList.add(new Employee("Harry Major", 25, 10000.00));
        employeeList.add(new Employee("Ethan Hardy", 65, 8000.00));
        employeeList.add(new Employee("Nancy Smith", 22, 12000.00));
        employeeList.add(new Employee("Deborah Sprightly", 29, 9000.00));
        employeeList.removeIf((Employee emp) -> emp.getAge() >= 30);
        System.out.println("Employees below the age of 30");
        employeeList.forEach(System.out::println);

	}
	
	private static List<String>  createList() {
        return Arrays.asList("iPhone x", "Ubuntu x", "Android x", "Mac OS X");
    }

}
