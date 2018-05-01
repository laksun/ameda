package com.yla.springboot.firstweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.yla.springboot.firstweb")
public class FirstWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstWebApplication.class, args);
	}
}
