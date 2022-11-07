package com.cgi.recom_muzix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//@SpringBootApplication(scanBasePackages = {"controller","service","model", "repository"})
@SpringBootApplication
@EnableEurekaClient

public class RecomMuzixApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecomMuzixApplication.class, args);
	}

}
