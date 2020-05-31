package com.jmendoza.swa.hexagonal.product.domain.services;

import com.jmendoza.swa.hexagonal.product.common.constants.ProductConstanst;
import com.jmendoza.swa.hexagonal.product.common.customannotations.UseCase;
import com.jmendoza.swa.hexagonal.product.common.exception.ResourceNotFoundException;
import com.jmendoza.swa.hexagonal.product.domain.model.Product;
import com.jmendoza.swa.hexagonal.product.domain.ports.inbound.GetProductsUseCase;
import com.jmendoza.swa.hexagonal.product.domain.ports.outbound.GetProductsPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@UseCase
public class GetProductsService implements GetProductsUseCase {

    private GetProductsPort getProductsPort;

    @Override
    public List<Product> getProducts() throws ResourceNotFoundException {

        List<Product> productList = getProductsPort.getProducts();
        if (productList.isEmpty())
            throw new ResourceNotFoundException(ProductConstanst.PRODUCTS_NOT_FOUND);

        return productList;
    }
}
