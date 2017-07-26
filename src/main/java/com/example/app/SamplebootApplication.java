package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.domain.model")
@EnableJpaRepositories("com.example.domain.repository")
@ComponentScan("com.example.domain.service")
@ComponentScan("com.example.config")
@ComponentScan
public class SamplebootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SamplebootApplication.class, args);
    }
}
