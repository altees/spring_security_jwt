package com.user.mangment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
@ComponentScan("com.user")
public class UserMangmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMangmentApplication.class, args);
	}

}
