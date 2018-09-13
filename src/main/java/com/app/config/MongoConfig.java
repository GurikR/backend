package com.app.config;

import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
@ComponentScan(basePackages = { "com.app.service" })
@EnableMongoRepositories(basePackages = { "com.app.data.repository" })
public class MongoConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(MongoConfig.class);
	
	@Bean
	public MongoDbFactory getMongoFactory() throws UnknownHostException{
		MongoClientURI mongoClientURI = new MongoClientURI("mongodb://localhost:27017/spring-mongo");
		MongoClient mongoClient = new MongoClient(mongoClientURI);
		
		LOGGER.info("------------mongo initialized---------------");
		return new SimpleMongoDbFactory(mongoClient,"spring-mongo");
	}
	
	@Bean
	public MongoTemplate mongoTemplate() throws UnknownHostException{
		return new MongoTemplate(getMongoFactory());
	}
}
