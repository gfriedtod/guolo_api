package com.api.guolo_api.adminMangement.infrastructure.out.persistences.repository;

import com.api.guolo_api.Entity.Ticket;
import com.api.guolo_api.Entity.TicketId;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, TicketId> {
    @NotNull Optional<Ticket> findById(@NotNull TicketId id);

    Collection<Ticket> findByLotterieId(UUID lotteryId);
}