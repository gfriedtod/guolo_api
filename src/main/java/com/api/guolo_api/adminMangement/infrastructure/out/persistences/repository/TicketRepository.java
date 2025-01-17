package com.api.guolo_api.adminMangement.infrastructure.out.persistences.repository;

import com.api.guolo_api.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    Optional<Ticket> findById(UUID id);

    Collection<Ticket> findByLotterieId(UUID lotteryId);
}