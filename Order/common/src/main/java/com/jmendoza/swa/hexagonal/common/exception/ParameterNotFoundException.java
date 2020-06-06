package com.jmendoza.swa.hexagonal.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ParameterNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public ParameterNotFoundException(String message) {
        super(message);
    }

    public ParameterNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
