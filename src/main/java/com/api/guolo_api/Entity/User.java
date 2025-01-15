package com.api.guolo_api.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "\"user\"")
@NoArgsConstructor
public class User {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "email", length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "password", length = Integer.MAX_VALUE)
    private String password;

    @Column(name = "role", length = Integer.MAX_VALUE)
    private String role;

}