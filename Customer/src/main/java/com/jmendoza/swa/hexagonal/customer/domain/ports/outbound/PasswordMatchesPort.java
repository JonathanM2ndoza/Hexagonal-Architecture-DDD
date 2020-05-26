package com.jmendoza.swa.hexagonal.customer.domain.ports.outbound;

public interface PasswordMatchesPort {

    boolean passwordMatchesPort(CharSequence rawPassword, String encodedPassword);
}
