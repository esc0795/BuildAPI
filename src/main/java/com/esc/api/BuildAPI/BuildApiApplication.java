package com.esc.api.BuildAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.esc.api.BuildAPI")
public class BuildApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuildApiApplication.class, args);
	}

}
