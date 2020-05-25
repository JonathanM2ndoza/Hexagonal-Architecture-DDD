package com.jmendoza.swa.hexagonal.customer.domain.ports.outbound;

public interface PasswordEncodePort {
    String passwordEncoder(String password);
}
