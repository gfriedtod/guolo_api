package com.api.guolo_api.adminMangement.infrastructure.out.persistences.repository;

import com.api.guolo_api.Entity.Ticket;
import com.api.guolo_api.Entity.TicketId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, TicketId> {
}