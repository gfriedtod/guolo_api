package com.api.guolo_api.authentication.domain.service;


import com.api.guolo_api.authentication.application.input.UserAuthInput;
import com.api.guolo_api.authentication.application.output.UserOutputPort;
import com.api.guolo_api.authentication.domain.model.*;
import com.api.guolo_api.authentication.infracsturcture.out.jwt.JwtHelper;
import com.api.guolo_api.mail.domain.dto.EmailRequest;
import com.api.guolo_api.mail.domain.service.MaileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserAuthService implements UserAuthInput {

    private final UserOutputPort userOutputPort;
    private final PasswordEncoder passwordEncoder;
    private final MaileService maileService;

    public Optional<LoginUserResponse> login(LoginRequest request) throws NoSuchAlgorithmException {
        var user = userOutputPort.loadUserByUsername(request.getEmail());
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            String token = JwtHelper.generateToken(new TokenDetails(user.getId(), user.getEmail()));
            return Optional.ofNullable(LoginUserResponse.builder().user(user).token(token).build());
        }
        return Optional.empty();
    }


    @Override
    public UserDto create(SignupRequest signupRequest) {
        try{
            String password = signupRequest.getPassword();
            var user  = userOutputPort.create(signupRequest,passwordEncoder);
            System.out.println(signupRequest.getPassword());
            var request = LoginRequest.builder().email(user.getEmail()).password(password).name(user.getName()).build();
            ObjectMapper mapper = new ObjectMapper();
            maileService.send(
                    EmailRequest.builder()
                            .to(signupRequest.getEmail())
                            .subject("Welcome to Paypro")
                            .message("<h1>Welcome to Paypro new Client</h1>\n" +
                                    "\n" +
                                    "<p>Hi " +signupRequest.getName() + "</p>\n" +
                                    "\n" +
                                    "<p>email: " +  signupRequest.getEmail()+ "</p>\n" +
                                    "\n" +
                                    "<p>password: " + password + "</p>\n" +
                                    "\n" +
                                    "<p>Thank you for registering with us. We are excited to have you join our community!</p>\n" +
                                    "\n" ).build()

            );

            return user;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDto update(UserDto userDto) {
        return userOutputPort.update(userDto);
    }


}
