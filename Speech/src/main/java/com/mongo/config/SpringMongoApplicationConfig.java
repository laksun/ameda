package com.mongo.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

@Configuration
public class SpringMongoApplicationConfig extends AbstractMongoConfiguration {
	
	@Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(Arrays.asList(new ServerAddress("mongo-db",
                27017)));
    }

    @Override
    protected String getDatabaseName() {
        return "local";
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.mongo.model";
    }

	

}
