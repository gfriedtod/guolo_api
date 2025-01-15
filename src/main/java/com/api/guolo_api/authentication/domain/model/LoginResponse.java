package com.api.guolo_api.authentication.domain.model;

import com.api.guolo_api.Entity.User;
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
