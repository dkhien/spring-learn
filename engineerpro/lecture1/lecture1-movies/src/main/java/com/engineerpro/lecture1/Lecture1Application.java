package com.engineerpro.lecture1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Lecture1Application {

	public static void main(String[] args) {
		SpringApplication.run(Lecture1Application.class, args);
	}

}
