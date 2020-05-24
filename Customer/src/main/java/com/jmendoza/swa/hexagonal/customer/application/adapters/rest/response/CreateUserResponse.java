package com.jmendoza.swa.hexagonal.customer.application.adapters.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserResponse {
    private String id;
}
