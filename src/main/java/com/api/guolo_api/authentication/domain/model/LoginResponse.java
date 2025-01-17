package com.api.guolo_api.authentication.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Data
public class LoginResponse {
    private String token;
    private UserDto user;
}
