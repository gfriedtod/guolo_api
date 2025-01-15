package com.api.guolo_api.authentication.application.input;


import com.api.guolo_api.authentication.domain.model.LoginRequest;
import com.api.guolo_api.authentication.domain.model.LoginUserResponse;
import com.api.guolo_api.authentication.domain.model.SignupRequest;
import com.api.guolo_api.authentication.domain.model.UserDto;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public interface UserAuthInput {

    public UserDto create(SignupRequest signupRequest);
    Optional<LoginUserResponse> login(LoginRequest loginRequest) throws NoSuchAlgorithmException;
}
