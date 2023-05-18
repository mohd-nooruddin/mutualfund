package com.searchmf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SearchMfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchMfApplication.class, args);
		System.out.println("Started SearchMfApplication");
	}
}