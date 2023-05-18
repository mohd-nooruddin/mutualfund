package com.mutualfunds.server.mf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MutualfundsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutualfundsServerApplication.class, args);
		System.out.println("Eureka Server Started");
	}

}
