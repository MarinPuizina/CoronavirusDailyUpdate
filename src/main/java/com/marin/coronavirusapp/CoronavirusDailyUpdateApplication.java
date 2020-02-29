package com.marin.coronavirusapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronavirusDailyUpdateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronavirusDailyUpdateApplication.class, args);
	}

}
