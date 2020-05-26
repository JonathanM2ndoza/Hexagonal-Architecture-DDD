package com.jmendoza.swa.hexagonal.customer.infrastracture.security;

import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.PasswordEncodePort;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.PasswordMatchesPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptAdapter implements PasswordEncodePort, PasswordMatchesPort {

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public String passwordEncoder(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public boolean passwordMatchesPort(CharSequence rawPassword, String encodedPassword) {
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }
}
