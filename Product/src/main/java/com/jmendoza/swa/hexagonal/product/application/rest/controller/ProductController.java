package com.jmendoza.swa.hexagonal.product.application.rest.controller;

import com.jmendoza.swa.hexagonal.product.application.rest.response.CreateProductResponse;
import com.jmendoza.swa.hexagonal.product.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.product.common.exception.ParameterNotFoundException;
import com.jmendoza.swa.hexagonal.product.common.exception.ResourceNotFoundException;
import com.jmendoza.swa.hexagonal.product.domain.model.Product;
import com.jmendoza.swa.hexagonal.product.domain.ports.inbound.CreateProductUseCase;
import com.jmendoza.swa.hexagonal.product.domain.ports.inbound.DeleteProductUseCase;
import com.jmendoza.swa.hexagonal.product.domain.ports.inbound.GetProductUseCase;
import com.jmendoza.swa.hexagonal.product.domain.ports.inbound.GetProductsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/products")
@AllArgsConstructor
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final GetProductsUseCase getProductsUseCase;
    private final GetProductUseCase getProductUseCase;

    @PostMapping
    public ResponseEntity<CreateProductResponse> createProduct(@Valid @RequestBody Product product) throws GlobalException, ParameterNotFoundException {
        createProductUseCase.createProduct(product);
        return ResponseEntity.ok().body(CreateProductResponse.builder().id(product.getId()).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable(value = "id") String id) throws ResourceNotFoundException {
        deleteProductUseCase.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() throws ResourceNotFoundException {
        List<Product> productList = getProductsUseCase.getProducts();
        return ResponseEntity.ok().body(productList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(value = "id") String id) throws ResourceNotFoundException {
        Product product = getProductUseCase.getProduct(id);
        return ResponseEntity.ok().body(product);
    }
}
