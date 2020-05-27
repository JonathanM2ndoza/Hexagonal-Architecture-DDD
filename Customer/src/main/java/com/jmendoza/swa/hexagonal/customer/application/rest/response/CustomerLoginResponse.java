package com.jmendoza.swa.hexagonal.customer.application.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerLoginResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String createdAt;
    private String updatedAt;
}
