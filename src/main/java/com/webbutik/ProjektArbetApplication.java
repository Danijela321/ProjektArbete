package com.webbutik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * Startar application
 * @author Danijela
 *
 */
@SpringBootApplication
@EnableAutoConfiguration (exclude = { SecurityAutoConfiguration.class })
public class ProjektArbetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektArbetApplication.class, args);
	}

	
}
