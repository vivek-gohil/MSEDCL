package com.msedcl.main.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(info = @Info(title = "Customer microservice REST API Documentation", description = "MyBank Customers microservice REST API Documentation", version = "v1", contact = @Contact(name = "Vivek Gohil", email = "tutor@mybank.com", url = "https://www.mybank.com"), license = @License(name = "Apache 2.0", url = "https://www.mybank.com")), externalDocs = @ExternalDocumentation(description = "MyBank Customers microservice REST API Documentation", url = "https://www.mybank.com/swagger-ui.html"))
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
