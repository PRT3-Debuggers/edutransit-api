package com.debuggers;

import com.debuggers.domain.Parent;
import com.debuggers.domain.User;
import com.debuggers.factory.ParentFactory;
import com.debuggers.factory.UserFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {

		// Create a user [Works!]
		User driverGazly = UserFactory.createUser(
				null,
				"Pierre",
				"Gazly",
				"gazly@gmail.com",
				"Gazly$06"
		);

		System.out.println("New Driver: " + driverGazly);

		//Create driver [Works with driverGazly Object]
//		Driver lewis = DriverFactory.createDriver( "None", "18", "14");
//
//		System.out.println(lewis);

		// Create a User
//		User user = UserFactory.createUser(
//				UserFactory.createUserId(),
//				"Thabo",
//				"Mokoena",
//				"thabo@example.com",
//				"Password123"
//		);

		System.out.println("User created: " + driverGazly);

		// Create a Parent using ParentFactory
		Parent parent = ParentFactory.createUser(null, driverGazly);

		System.out.println("Parent created: " + parent);


		// Open browser after app starts
		try {
			if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().browse(new URI("http://localhost:8081"));
			} else {
				System.out.println("Desktop not supported.");
			}
		} catch (Exception e) {
			System.err.println("Failed to open browser: " + e.getMessage());
		}
	}
}