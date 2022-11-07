package com.cgi.fav_muzix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableEurekaClient
@SpringBootApplication

public class FavMuzixApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavMuzixApplication.class, args);
	}

}
