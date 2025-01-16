package com.api.guolo_api.userManagement.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * DTO for {@link com.api.guolo_api.Entity.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto implements Serializable {
    private UUID id;
//    private OffsetDateTime createdAt;
    private String name;
    private String password;
    private String role;
    private String email;
}