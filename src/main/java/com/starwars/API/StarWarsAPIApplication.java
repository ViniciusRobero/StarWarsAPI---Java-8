package com.starwars.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.mongotest")
@EnableMongoRepositories("com.mongotest")
public class StarWarsAPIApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarWarsAPIApplication.class, args);
    }

}
