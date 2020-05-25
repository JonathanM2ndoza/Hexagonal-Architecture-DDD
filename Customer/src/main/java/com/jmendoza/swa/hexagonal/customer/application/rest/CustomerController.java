package com.jmendoza.swa.hexagonal.customer.application.rest;

import com.jmendoza.swa.hexagonal.customer.application.rest.response.CreateUserResponse;
import com.jmendoza.swa.hexagonal.customer.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import com.jmendoza.swa.hexagonal.customer.domain.ports.inbound.CreateCustomerUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
    }

    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody Customer customer) throws GlobalException {
        createCustomerUseCase.createCustomer(customer);
        return ResponseEntity.ok().body(CreateUserResponse.builder().id(customer.getId()).build());
    }
}
