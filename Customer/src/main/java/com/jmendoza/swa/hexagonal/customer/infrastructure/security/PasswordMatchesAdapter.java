package com.jmendoza.swa.hexagonal.customer.infrastructure.security;

import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.PasswordMatchesPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordMatchesAdapter implements PasswordMatchesPort {

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean passwordMatchesPort(CharSequence rawPassword, String encodedPassword) {
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }
}
