package com.mutualfunds.mf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MutualfundsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutualfundsApplication.class, args);
		System.out.println("MutualFunds Wallet Started");
	}

}
