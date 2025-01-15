package com.api.guolo_api.authentication.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignupResponse {
    private String message;
    private UserDto adminDto;
}
