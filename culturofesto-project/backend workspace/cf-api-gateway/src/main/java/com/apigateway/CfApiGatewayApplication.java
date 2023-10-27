package com.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CfApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CfApiGatewayApplication.class, args);
	}

}
