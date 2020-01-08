package com.salinas.matias.juan.morse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.salinas.matias.juan.morse"})
public class MorseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MorseApplication.class, args);
	}
}
