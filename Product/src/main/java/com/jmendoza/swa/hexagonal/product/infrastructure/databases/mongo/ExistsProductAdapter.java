package com.jmendoza.swa.hexagonal.product.infrastructure.databases.mongo;

import com.jmendoza.swa.hexagonal.product.domain.ports.outbound.ExistsProductPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsProductAdapter implements ExistsProductPort {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean existsBySerialNumber(String serialNumber) {
        return productRepository.existsBySerialNumber(serialNumber);
    }
}
