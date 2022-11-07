package com.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;




@SpringBootApplication
@PropertySource("classpath:dbconfig.properties")
@EnableEurekaClient
public class UserServiceApp {
	
	public static void main(String[] args) {

		SpringApplication.run(UserServiceApp.class, args);

	}



}
