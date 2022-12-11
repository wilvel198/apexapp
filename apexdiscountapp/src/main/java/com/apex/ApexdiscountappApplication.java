package com.apex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Apex Point Calculation API", version = "2.0", description = "Apex points app"))
public class ApexdiscountappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApexdiscountappApplication.class, args);
	}
}
