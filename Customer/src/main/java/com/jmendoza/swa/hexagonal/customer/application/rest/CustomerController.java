package com.jmendoza.swa.hexagonal.customer.application.rest;

import com.jmendoza.swa.hexagonal.customer.application.rest.response.CreateUserResponse;
import com.jmendoza.swa.hexagonal.customer.application.rest.response.CustomerLoginResponse;
import com.jmendoza.swa.hexagonal.customer.application.rest.response.ResponseMapper;
import com.jmendoza.swa.hexagonal.customer.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.customer.common.exception.ResourceNotFoundException;
import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import com.jmendoza.swa.hexagonal.customer.domain.ports.inbound.CreateCustomerUseCase;
import com.jmendoza.swa.hexagonal.customer.domain.ports.inbound.CustomerLoginUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final CustomerLoginUseCase customerLoginUseCase;
    private final ResponseMapper responseMapper;

    @PostMapping
    public ResponseEntity<CreateUserResponse> createCustomer(@Valid @RequestBody Customer customer) throws GlobalException {
        createCustomerUseCase.createCustomer(customer);
        return ResponseEntity.ok().body(CreateUserResponse.builder().id(customer.getId()).build());
    }

    @PostMapping("/login")
    public ResponseEntity<CustomerLoginResponse> customerLogin(@Valid @RequestBody Customer customer) throws ResourceNotFoundException, GlobalException {
        CustomerLoginResponse customerLoginResponse = responseMapper.convertCustomerToCustomerLoginResponse(customerLoginUseCase.customerLogin(customer.getEmail(), customer.getPassword()));
        return ResponseEntity.ok().body(customerLoginResponse);
    }
}
