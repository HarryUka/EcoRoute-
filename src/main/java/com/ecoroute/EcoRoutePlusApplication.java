package com.ecoroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EcoRoutePlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcoRoutePlusApplication.class, args);
    }
} 