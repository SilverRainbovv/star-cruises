package com.didenko.starcruises;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableCaching
@SpringBootApplication
public class StarCruisesApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarCruisesApplication.class, args);
    }

}