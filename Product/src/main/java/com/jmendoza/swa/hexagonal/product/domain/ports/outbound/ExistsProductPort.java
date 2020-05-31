package com.jmendoza.swa.hexagonal.product.domain.ports.outbound;

public interface ExistsProductPort {
    boolean existsBySerialNumber(String serialNumber);
}
