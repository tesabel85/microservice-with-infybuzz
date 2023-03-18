package com.microservice.student.studentservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan({"com.microservice.student.studentservice.controller","com.microservice.student.studentservice.service"})
@EntityScan("com.microservice.student.studentservice.entity")
@EnableJpaRepositories("com.microservice.student.studentservice.repository")
@EnableFeignClients("com.microservice.student.studentservice.feignclients")
public class StudentServiceApplication {

//	@Value("${address.service.url}")
//	private String addressServiceUrl;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

//	@Bean
//	public WebClient webClient() {
//		WebClient webClient = WebClient.builder().baseUrl(addressServiceUrl).build();
//		return webClient;
//	}
}
