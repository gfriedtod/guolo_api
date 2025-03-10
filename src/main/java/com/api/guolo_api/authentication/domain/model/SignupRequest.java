package com.api.guolo_api.authentication.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignupRequest {
    private String name;
    private String email;
    private String password;
    private String role;
    private String phone;
    private String location;
}
