package com.api.guolo_api.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = true)
    @GeneratedValue
    private UUID id;

    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "password", length = Integer.MAX_VALUE)
    private String password;
    @Column(name = "role", length = Integer.MAX_VALUE)
    private String role;
    @Column(name = "email", columnDefinition = "email")
    private String email;
}
