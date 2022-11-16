package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("Example log from {}", Application.class.getSimpleName());
		System.out.println("Application Start !");
	}
}

/*Partie server :  
BONUS : configuer un job de type maven sur jenkins*/