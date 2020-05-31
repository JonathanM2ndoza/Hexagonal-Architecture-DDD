package com.jmendoza.swa.hexagonal.product.domain.services;

import com.jmendoza.swa.hexagonal.product.common.constants.ProductConstanst;
import com.jmendoza.swa.hexagonal.product.common.customannotations.UseCase;
import com.jmendoza.swa.hexagonal.product.common.exception.ResourceNotFoundException;
import com.jmendoza.swa.hexagonal.product.domain.model.Product;
import com.jmendoza.swa.hexagonal.product.domain.ports.inbound.DeleteProductUseCase;
import com.jmendoza.swa.hexagonal.product.domain.ports.outbound.DeleteProductPort;
import com.jmendoza.swa.hexagonal.product.domain.ports.outbound.GetProductIdPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@UseCase
public class DeleteProductService implements DeleteProductUseCase {

    private GetProductIdPort getProductIdPort;
    private DeleteProductPort deleteProductPort;

    @Override
    public void deleteProduct(String id) throws ResourceNotFoundException {
        Product product = getProductIdPort.getProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ProductConstanst.PRODUCT_NOT_FOUND + id));
        deleteProductPort.deleteProduct(product);
    }
}
