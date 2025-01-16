package com.api.guolo_api.userManagement.infrastructure.out.persistences.repository;

import com.api.guolo_api.Entity.Ticket;
import com.api.guolo_api.Entity.TicketId;
import com.api.guolo_api.Entity.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface UserUserTicketRepository extends JpaRepository<Ticket, TicketId> {
  Collection<Ticket> findByLotterieIdAndStatus(UUID lotterie_id, TicketStatus status);

}