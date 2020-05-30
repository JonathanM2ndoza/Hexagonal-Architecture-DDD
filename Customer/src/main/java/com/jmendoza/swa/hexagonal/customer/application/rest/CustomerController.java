package com.jmendoza.swa.hexagonal.customer.application.rest;

import com.jmendoza.swa.hexagonal.customer.application.rest.response.CreateCustomerResponse;
import com.jmendoza.swa.hexagonal.customer.application.rest.response.CustomerLoginResponse;
import com.jmendoza.swa.hexagonal.customer.application.rest.response.ResponseMapper;
import com.jmendoza.swa.hexagonal.customer.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.customer.common.exception.ParameterNotFoundException;
import com.jmendoza.swa.hexagonal.customer.common.exception.ResourceNotFoundException;
import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import com.jmendoza.swa.hexagonal.customer.domain.ports.inbound.CreateCustomerUseCase;
import com.jmendoza.swa.hexagonal.customer.domain.ports.inbound.CustomerLoginUseCase;
import com.jmendoza.swa.hexagonal.customer.domain.ports.inbound.DeleteCustomerUseCase;
import com.jmendoza.swa.hexagonal.customer.domain.ports.inbound.UpdateCustomerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final CustomerLoginUseCase customerLoginUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;

    private final ResponseMapper responseMapper;

    @PostMapping
    public ResponseEntity<CreateCustomerResponse> createCustomer(@Valid @RequestBody Customer customer) throws GlobalException, ParameterNotFoundException {
        createCustomerUseCase.createCustomer(customer);
        return ResponseEntity.ok().body(CreateCustomerResponse.builder().id(customer.getId()).build());
    }

    @PostMapping("/login")
    public ResponseEntity<CustomerLoginResponse> customerLogin(@Valid @RequestBody Customer customer) throws ResourceNotFoundException, GlobalException, ParameterNotFoundException {
        CustomerLoginResponse customerLoginResponse = responseMapper.convertCustomerToCustomerLoginResponse(customerLoginUseCase.customerLogin(customer.getEmail(), customer.getPassword()));
        return ResponseEntity.ok().body(customerLoginResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable(value = "id") String id) throws ResourceNotFoundException {
        deleteCustomerUseCase.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCustomer(@PathVariable(value = "id") String id,
                                         @Valid @RequestBody Customer customer) throws ResourceNotFoundException {
        updateCustomerUseCase.updateCustomer(id, customer);
        return ResponseEntity.noContent().build();
    }
}
