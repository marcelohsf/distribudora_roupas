package com.distribuidora.Distribuidora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = "com.distribuidora")
@EntityScan(basePackages = {"com.distribuidora.domains", "com.distribuidora.domains.enums"})
@EnableJpaRepositories(basePackages = "com.distribuidora.repositories")
@SpringBootApplication
public class DistribuidoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistribuidoraApplication.class, args);
	}

}
