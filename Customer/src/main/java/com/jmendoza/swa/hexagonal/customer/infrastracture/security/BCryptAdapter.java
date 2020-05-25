package com.jmendoza.swa.hexagonal.customer.infrastracture.security;

import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.PasswordEncodePort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptAdapter implements PasswordEncodePort {

    @Override
    public String passwordEncoder(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }
}
