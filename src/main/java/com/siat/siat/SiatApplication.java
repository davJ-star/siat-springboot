package com.siat.siat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SiatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiatApplication.class, args);
	}

}
