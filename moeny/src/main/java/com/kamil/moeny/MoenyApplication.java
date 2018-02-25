package com.kamil.moeny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages={"repository", "model", "service", "ui", "configuration"})
public class MoenyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoenyApplication.class, args);
	}
}
