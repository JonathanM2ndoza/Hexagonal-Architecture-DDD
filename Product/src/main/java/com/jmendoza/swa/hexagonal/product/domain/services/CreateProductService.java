package com.jmendoza.swa.hexagonal.product.domain.services;

import com.jmendoza.swa.hexagonal.product.common.constants.ProductConstanst;
import com.jmendoza.swa.hexagonal.product.common.customannotations.UseCase;
import com.jmendoza.swa.hexagonal.product.common.exception.ParameterNotFoundException;
import com.jmendoza.swa.hexagonal.product.domain.model.Product;
import com.jmendoza.swa.hexagonal.product.domain.ports.inbound.CreateProductUseCase;
import com.jmendoza.swa.hexagonal.product.domain.ports.outbound.CreateProductPort;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@AllArgsConstructor
@UseCase
public class CreateProductService implements CreateProductUseCase {

    private CreateProductPort createProductPort;

    @Override
    public void createProduct(Product product) throws ParameterNotFoundException {

        if (StringUtils.isBlank(product.getProductName()))
            getMessageParameterNotFoundException("productName");
        if (StringUtils.isBlank(product.getProductDescription()))
            getMessageParameterNotFoundException("productDescription");
        if (product.getPrice() == null || Double.compare(product.getPrice(), ProductConstanst.D_2) <= ProductConstanst.INT)
            getMessageParameterNotFoundException("price");

        createProductPort.createProduct(product);
    }

    private void getMessageParameterNotFoundException(String parameter) throws ParameterNotFoundException {
        throw new ParameterNotFoundException(ProductConstanst.REQUIRED_PARAMETER + "\"" + parameter + "\"" + ProductConstanst.IS_NOT_PRESENT);
    }
}
