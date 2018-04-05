package com.main.anwar.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.main.anwar.endpoint.data.Door;
import com.main.anwar.endpoint.service.DoorRepository;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(DoorRepository repository) {
		return (args) -> {
			Door door = new Door("North");
			door.onCreate();

			repository.save(door);
			// fetch all customers
			log.info("Doors found with findAll():");
			log.info("-------------------------------");
			for (Door d : repository.findAll()) {
				log.info(d.toString());
			}
		};
	}
}
