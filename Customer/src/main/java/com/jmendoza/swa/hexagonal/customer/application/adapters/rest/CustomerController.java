package com.jmendoza.swa.hexagonal.customer.application.adapters.rest;

import com.jmendoza.swa.hexagonal.customer.application.adapters.rest.response.CreateUserResponse;
import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import com.jmendoza.swa.hexagonal.customer.domain.ports.inbound.CreateCustomerUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
    }

    @PostMapping("/customer")
    public ResponseEntity createUser(@Valid @RequestBody Customer customer) {
        createCustomerUseCase.createCustomer(customer);
        return ResponseEntity.ok().body(CreateUserResponse.builder().id(customer.getId()).build());
    }
}
