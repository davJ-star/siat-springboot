package com.example.testsiat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// @SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication

public class TestsiatApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestsiatApplication.class, args);
	}

}
