package com.cts.sbd.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

	@Value("${gretingService.greeting}")
	private String greeting;
	
	public String greetUser(String userName) {
		return String.format("%s %s!", greeting,userName);
	}
}
