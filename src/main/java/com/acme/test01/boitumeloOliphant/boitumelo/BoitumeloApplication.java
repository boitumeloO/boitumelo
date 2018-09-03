package com.acme.test01.boitumeloOliphant.boitumelo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = CustomerRepository.class)
public class BoitumeloApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoitumeloApplication.class, args);
	}
}
