package com.jmendoza.swa.hexagonal.customer.domain.ports.outbound;

public interface EncryptPasswordPort {
    String passwordEncoder(String password);
}
