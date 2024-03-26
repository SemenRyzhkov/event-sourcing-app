package ru.ryzhkov.event.sourcing.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class EventSourcingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventSourcingAppApplication.class, args);
	}

}
