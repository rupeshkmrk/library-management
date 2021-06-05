package com.hcl.librarymanagement.HackToHire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.hcl.librarymanagement.HackToHire")
public class HackToHireApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackToHireApplication.class, args);
	}

}
