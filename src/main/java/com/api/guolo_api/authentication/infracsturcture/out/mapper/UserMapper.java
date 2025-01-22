package com.api.guolo_api.authentication.infracsturcture.out.mapper;


import com.api.guolo_api.Entity.User;
import com.api.guolo_api.authentication.domain.model.UserDto;

import java.time.OffsetDateTime;

public class UserMapper {

   public static User toEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .createdAt(OffsetDateTime.from(userDto.getCreatedAt()))
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }

   public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .createdAt(user.getCreatedAt())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }

    public static User toEntityWithoutDependencies(UserDto user) {
        return User.builder()
                .id(user.getId())
//                .createdAt(OffsetDateTime.from(user.getCreatedAt()))
                .name(user.getName())
                .email(user.getEmail())
//                .password(user.getPassword())
//                .role(user.getRole())
                .build();
    }
}
