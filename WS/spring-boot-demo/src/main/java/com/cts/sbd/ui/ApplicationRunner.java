package com.cts.sbd.ui;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cts.sbd.service.GreetingService;

@Component
public class ApplicationRunner implements CommandLineRunner {

	@Autowired
	private Scanner scanner;
	
	@Autowired
	private GreetingService greetingService;
	
	private Logger logger;
	
	public ApplicationRunner() {
		this.logger=LoggerFactory.getLogger(this.getClass());
	}
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("The spring boot application is executing! Hello Welcome to Spring Boot");
		
		logger.info("Enter your name: ");
		String userName = scanner.next();
		logger.info(greetingService.greetUser(userName));
	}
	

}
