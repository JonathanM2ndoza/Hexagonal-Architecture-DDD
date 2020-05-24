package com.jmendoza.swa.hexagonal.customer.infrastracture.adapters.configuration.boot;

import com.jmendoza.swa.hexagonal.customer.domain.services.CreateCustomerService;
import com.jmendoza.swa.hexagonal.customer.infrastracture.adapters.databases.mongo.CustomerRepositoryAdapter;
import com.jmendoza.swa.hexagonal.customer.infrastracture.adapters.security.EncryptAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    CreateCustomerService createCustomerService(CustomerRepositoryAdapter customerRepositoryAdapter, EncryptAdapter encryptAdapter) {
        return new CreateCustomerService(customerRepositoryAdapter, encryptAdapter);
    }
}
