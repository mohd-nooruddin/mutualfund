package com.register.emailverification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient 
public class RegisterVerificationApplication {

    public static void main(String[] args) {

        SpringApplication.run(RegisterVerificationApplication.class, args);
    }

}
