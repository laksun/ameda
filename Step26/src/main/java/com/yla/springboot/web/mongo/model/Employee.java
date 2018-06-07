package com.yla.springboot.web.mongo.model;

public class Employee {
	
	String name;
	int age;
	double salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
