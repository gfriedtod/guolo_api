package com.api.guolo_api.adminMangement.infrastructure.out.persistences.repository;

import com.api.guolo_api.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}