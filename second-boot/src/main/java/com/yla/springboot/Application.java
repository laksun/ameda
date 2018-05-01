package com.yla.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@ComponentScan({"com.yla.speech","com.yla.springboot","com.yla.survey"})
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

	}
	
	
	//the bean will be created if the profile is production
	@Profile("prod")
	@Bean
	public String dummy() {
		return "a dummy string";
	}

}