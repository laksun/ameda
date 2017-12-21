package com.yla.mongo.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.yla.demo.CatalogService;

@Configuration
@EnableMongoRepositories("com.yla.mongo.repositories")
@ComponentScan(basePackageClasses = {CatalogService.class})
public class SpringMongoApplicationConfig extends AbstractMongoConfiguration {
	
	
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(Arrays.asList(new ServerAddress("mongo-db",27017)));
    }
    
   

    
    protected String getDatabaseName() {
        return "local";
    }

    
    protected String getMappingBasePackage() {
        return "com.yla";
    }

	

}
