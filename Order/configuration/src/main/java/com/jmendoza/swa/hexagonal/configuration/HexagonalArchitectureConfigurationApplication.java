package com.jmendoza.swa.hexagonal.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.jmendoza.swa.hexagonal.*"})
public class HexagonalArchitectureConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(HexagonalArchitectureConfigurationApplication.class, args);
    }

}
