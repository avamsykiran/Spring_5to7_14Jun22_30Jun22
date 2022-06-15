package com.cts.sbdjd;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDataJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaDemoApplication.class, args);
	}

	@Bean
	public Scanner kbin() {
		return new Scanner(System.in);
	}
}
