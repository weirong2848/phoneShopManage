package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"com.service","com.controller","com.entity","com.config"})
public class MainMainageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainMainageApplication.class, args);
    }
}
