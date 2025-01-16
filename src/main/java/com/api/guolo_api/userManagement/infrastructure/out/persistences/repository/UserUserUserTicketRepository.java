package com.api.guolo_api.userManagement.infrastructure.out.persistences.repository;

import com.api.guolo_api.Entity.UserTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserUserUserTicketRepository extends JpaRepository<UserTicket, UUID> {
}