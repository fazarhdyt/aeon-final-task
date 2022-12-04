package com.aeon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AeonApplication {

	public static void main(String[] args) {
		SpringApplication.run(AeonApplication.class, args);
	}

}
