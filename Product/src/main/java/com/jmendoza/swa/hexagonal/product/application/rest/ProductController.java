package com.jmendoza.swa.hexagonal.product.application.rest;

import com.jmendoza.swa.hexagonal.product.common.exception.ParameterNotFoundException;
import com.jmendoza.swa.hexagonal.product.application.rest.response.CreateProductResponse;
import com.jmendoza.swa.hexagonal.product.domain.model.Product;
import com.jmendoza.swa.hexagonal.product.domain.ports.inbound.CreateProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/products")
@AllArgsConstructor
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    //private final DeleteCustomerUseCase deleteCustomerUseCase;

    @PostMapping
    public ResponseEntity<CreateProductResponse> createProduct(@Valid @RequestBody Product product) throws ParameterNotFoundException {
        createProductUseCase.createProduct(product);
        return ResponseEntity.ok().body(CreateProductResponse.builder().id(product.getId()).build());
    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable(value = "id") String id) throws ResourceNotFoundException {
        deleteCustomerUseCase.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }*/

}
