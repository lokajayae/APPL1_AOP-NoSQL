package com.configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.aspect.EmployeeServiceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
        
import com.mongodb.MongoClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.authentication.UserCredentials;

/**
 *
 * @author Evan Lokajaya
 */


@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.")
@EnableMongoRepositories({ "com.repository" })
public class MongoConfig{
    @Bean
    public EmployeeServiceAspect employeeServiceAspect(){
        return new EmployeeServiceAspect();
    }
    
    @Bean
    MongoDbFactory mongoDbFactory() throws Exception{
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        UserCredentials userCredentials = new UserCredentials("", "");
        return new SimpleMongoDbFactory(mongoClient, "employee", userCredentials);
    }
    
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
}
