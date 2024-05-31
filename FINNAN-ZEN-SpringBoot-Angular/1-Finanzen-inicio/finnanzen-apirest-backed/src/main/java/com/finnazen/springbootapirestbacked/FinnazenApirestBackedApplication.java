package com.finnazen.springbootapirestbacked;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//@SpringBootApplication(scanBasePackages = "com.finnazen.springbootapirestbacked")
@SpringBootApplication
public class FinnazenApirestBackedApplication {
	public static void main(String[] args) {
		SpringApplication.run(FinnazenApirestBackedApplication.class, args);
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPassword = "12345";
		String encodedPassword = passwordEncoder.encode(rawPassword);
		System.out.println("Encoded password: " + encodedPassword);
	}

}
