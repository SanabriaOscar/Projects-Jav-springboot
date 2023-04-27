package com.example.springbootapirestbacked;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SpringbootApirestBackedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApirestBackedApplication.class, args);
	}

}
