package com.bridgelabz.employeepayrollapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeepayrollappApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(EmployeepayrollappApplication.class, args);
		log.info(context.getEnvironment().getProperty("environment"));
		log.info(context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
