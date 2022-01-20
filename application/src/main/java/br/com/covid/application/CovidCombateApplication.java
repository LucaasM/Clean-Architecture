package br.com.covid.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CovidCombateApplication {
    public static void main(String [] args) {
        SpringApplication.run(CovidCombateApplication.class, args);
    }
}
