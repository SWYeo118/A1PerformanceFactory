package com.example.a1performancefactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan("com.example")
@SpringBootApplication
public class A1PerformanceFactoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(A1PerformanceFactoryApplication.class, args);
	}

}
