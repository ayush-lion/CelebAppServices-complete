package com.ctn.celebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.ctn.celebApp.entity")
@EnableJpaRepositories("com.ctn.celebApp.dao")
@ComponentScan(basePackages={"com.ctn.celebApp"})
@SpringBootApplication
public class CelebApplication extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		System.out.println("hello");
		SpringApplication.run(CelebApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CelebApplication.class);
    }
}