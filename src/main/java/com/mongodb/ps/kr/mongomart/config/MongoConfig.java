package com.mongodb.ps.kr.mongomart.config;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration  {

    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Override
    protected boolean autoIndexCreation() {
       return true ;
    }
}
