package com.jmendoza.swa.hexagonal.customer.infrastructure.security;

import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.PasswordEncodePort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncodeAdapter implements PasswordEncodePort {

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public String passwordEncoder(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
