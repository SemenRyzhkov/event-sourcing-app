package ru.ryzhkov.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = "ru.ryzhkov")
@ComponentScan(basePackages = "ru.ryzhkov")
@EnableJpaRepositories(basePackages = "ru.ryzhkov.*")
public class EventSourcingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventSourcingAppApplication.class, args);
	}

}
