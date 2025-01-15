package com.api.guolo_api.authentication.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {
   private String email;
   private String password;
   private String name;
}
