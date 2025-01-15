package com.api.guolo_api.authentication.infracsturcture.out.adapter;


import com.api.guolo_api.Entity.User;
import com.api.guolo_api.authentication.application.output.UserOutputPort;
import com.api.guolo_api.authentication.domain.model.LoginRequest;
import com.api.guolo_api.authentication.domain.model.SignupRequest;
import com.api.guolo_api.authentication.domain.model.UserDto;
import com.api.guolo_api.authentication.infracsturcture.out.mapper.UserMapper;
import com.api.guolo_api.authentication.infracsturcture.out.persitence.repository.UserAuthRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;

public class UserAuthPersistenceAdapter implements UserOutputPort {

    private final UserAuthRepository userRepository;
    private final ModelMapper modelMapper;

    public UserAuthPersistenceAdapter(UserAuthRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto loadUserByUsername(String username) {
        var user = userRepository.findByEmail(username);
        return user.map(UserMapper::toDto).orElse(null);
    }

    @Override
    public UserDto login(LoginRequest loginRequest) {
        var user = userRepository.findByEmail(loginRequest.getEmail());
        return user.map(user1 -> modelMapper.map(user1, UserDto.class)).orElse(null);

    }

    @Transactional
    @Override
    public UserDto create(SignupRequest signupRequest, PasswordEncoder passwordEncoder) {

        signupRequest.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        return UserMapper.toDto(userRepository.save(User.builder().name(signupRequest.getName()).email(signupRequest.getEmail()).password(signupRequest.getPassword()).role(signupRequest.getRole()).createdAt(OffsetDateTime.now()).build()));
    }

}
