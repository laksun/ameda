package com.aws.polly.db;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.Mongo;

//Configuring Spring data Mongo
public class ConfigureMongoDB {
	
	@Bean
	public MongoDbFactory mongoDbFactory(Environment environment) throws Exception{
		String databaseName = environment.getProperty("mongo.db");
		String host = environment.getProperty("mongo.host");
		Mongo  mongo = new Mongo(host);
		return new SimpleMongoDbFactory(mongo, databaseName);
	}
	
	@Bean
	public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory) {
		return new MongoTemplate(mongoDbFactory);
	}
	
	@Bean
	public GridFsTemplate gridFsTemplate(MongoDbFactory mongoDbfactory, MongoTemplate mongoTemplate) throws Exception{
		return new GridFsTemplate(mongoDbfactory, mongoTemplate.getConverter());
	}

}
