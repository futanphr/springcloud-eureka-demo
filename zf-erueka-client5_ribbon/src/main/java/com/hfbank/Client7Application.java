package com.hfbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Client7Application {
    public static void main(String[] args) {
        SpringApplication.run(Client7Application.class, args);
    }
}