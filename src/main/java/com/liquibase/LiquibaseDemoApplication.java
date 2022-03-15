package com.liquibase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.liquibase.repo"})
public class LiquibaseDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(LiquibaseDemoApplication.class, args);
	}

}
