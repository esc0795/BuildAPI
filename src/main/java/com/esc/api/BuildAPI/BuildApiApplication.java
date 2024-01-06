package com.esc.api.BuildAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.esc.api.BuildAPI.model")
public class BuildApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuildApiApplication.class, args);
	}

}
