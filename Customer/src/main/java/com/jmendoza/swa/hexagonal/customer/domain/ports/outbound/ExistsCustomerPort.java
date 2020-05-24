package com.jmendoza.swa.hexagonal.customer.domain.ports.outbound;

public interface ExistsCustomerPort {
    boolean existsByEmail(String email);
}
