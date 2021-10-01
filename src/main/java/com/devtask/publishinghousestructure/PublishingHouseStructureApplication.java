package com.devtask.publishinghousestructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PublishingHouseStructureApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublishingHouseStructureApplication.class, args);
	}

}
