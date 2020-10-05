package com.mytest.calculate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication

public class CalculateApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CalculateApplication.class, args);
	}
}
