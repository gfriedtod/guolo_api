package com.api.guolo_api.authentication.application.output;


import com.api.guolo_api.authentication.domain.model.LoginRequest;
import com.api.guolo_api.authentication.domain.model.SignupRequest;
import com.api.guolo_api.authentication.domain.model.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserOutputPort {
    UserDto loadUserByUsername(String username);
    UserDto update(UserDto userDto);

    UserDto login(LoginRequest loginRequest);
   UserDto create(SignupRequest signupRequest, PasswordEncoder passwordEncoder);
}
