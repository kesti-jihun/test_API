package com.kesti.test.test_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TestApiApplication extends SpringBootServletInitializer {

	//war추가
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(TestApiApplication.class);
	}
	//war추가

	public static void main(String[] args) {
		SpringApplication.run(TestApiApplication.class, args);
	}
}
