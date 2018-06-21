package com.yla.datamuse.yladatamuse;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.*;

//TODO

//insert mongo db
//https://www.djamware.com/post/59b606e280aca768e4d2b13b/spring-boot-mvc-data-and-mongodb-crud-java-web-application

@ComponentScan({"com.yla.datamuse.yladatamuse","com.yla.datamuse.yladatamuse.controllers","com.yla.jwi"})
@Configuration
@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class YlaDatamuseApplication {

	public static void main(String[] args) {
		SpringApplication.run(YlaDatamuseApplication.class, args);
	}
}
