package com.cts.sbdjwd.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceImpl implements GreetService {

	@Override
	public String greet(String userName) {
		String greeting="";
		
		int h = LocalDateTime.now().getHour();
		
		if(h<=11) greeting="Good Morning ";
		else if(h<=18) greeting="Good AfterNoon ";
		else greeting="Good Evening ";
	
		return String.format("%s %s!", greeting,userName);
	}
}
