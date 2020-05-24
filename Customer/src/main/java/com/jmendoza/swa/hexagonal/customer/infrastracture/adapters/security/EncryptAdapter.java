package com.jmendoza.swa.hexagonal.customer.infrastracture.adapters.security;

import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.EncryptPasswordPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncryptAdapter implements EncryptPasswordPort {

    @Override
    public String passwordEncoder(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }
}
