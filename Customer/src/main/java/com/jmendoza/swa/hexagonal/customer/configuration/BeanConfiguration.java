package com.jmendoza.swa.hexagonal.customer.configuration;

import com.jmendoza.swa.hexagonal.customer.domain.services.CreateCustomerService;
import com.jmendoza.swa.hexagonal.customer.infrastracture.adapters.databases.mongo.CustomerRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    CreateCustomerService createCustomerService(CustomerRepositoryAdapter customerRepositoryAdapter) {
        return new CreateCustomerService(customerRepositoryAdapter);
    }
}
