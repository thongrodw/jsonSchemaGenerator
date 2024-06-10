package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.utils.Generator;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		try {
			System.out.println("Generating Schema");
			Generator generator = new Generator();
			generator.generateAndExportJsonSchema(User.class, "schema.json");
			System.out.println("Completed Generating Schema");
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
