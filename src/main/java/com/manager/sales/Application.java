package com.manager.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.manager")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
