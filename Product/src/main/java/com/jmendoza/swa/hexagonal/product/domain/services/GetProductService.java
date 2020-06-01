package com.jmendoza.swa.hexagonal.product.domain.services;

import com.jmendoza.swa.hexagonal.product.common.constants.ProductConstanst;
import com.jmendoza.swa.hexagonal.product.common.customannotations.UseCase;
import com.jmendoza.swa.hexagonal.product.common.exception.ResourceNotFoundException;
import com.jmendoza.swa.hexagonal.product.domain.model.Product;
import com.jmendoza.swa.hexagonal.product.domain.ports.inbound.GetProductUseCase;
import com.jmendoza.swa.hexagonal.product.domain.ports.outbound.GetProductIdPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@UseCase
public class GetProductService implements GetProductUseCase {

    private GetProductIdPort getProductIdPort;

    @Override
    public Product getProduct(String id) throws ResourceNotFoundException {
        return getProductIdPort.getProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ProductConstanst.PRODUCT_NOT_FOUND + id));
    }
}
