package com.myChatApp.myChatApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication

public class MyChatAppApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MyChatAppApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(MyChatAppApplication.class, args);
	}


}

