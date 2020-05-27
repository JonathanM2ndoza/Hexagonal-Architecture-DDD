package com.jmendoza.swa.hexagonal.customer.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String createdAt;
    private String updatedAt;
}
