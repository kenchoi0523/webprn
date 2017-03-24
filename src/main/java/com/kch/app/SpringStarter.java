package com.kch.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableAutoConfiguration
@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = "com.kch.domain")
@EnableJpaRepositories(basePackages = "com.kch.repository")
@ComponentScan(basePackages = "com.kch.controller")
@ComponentScan(basePackages = "com.kch.service")
public class SpringStarter {

	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringStarter.class, args);
    }
}
