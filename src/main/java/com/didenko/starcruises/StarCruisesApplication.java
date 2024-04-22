package com.didenko.starcruises;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class StarCruisesApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarCruisesApplication.class, args);
    }

}