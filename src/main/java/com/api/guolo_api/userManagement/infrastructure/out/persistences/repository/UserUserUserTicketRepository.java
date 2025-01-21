package com.api.guolo_api.userManagement.infrastructure.out.persistences.repository;

import com.api.guolo_api.Entity.LotteryStatus;
import com.api.guolo_api.Entity.UserTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserUserUserTicketRepository extends JpaRepository<UserTicket, UUID> {

    List<UserTicket> findByUserIdAndTicketLotterieStatus(UUID user_id, LotteryStatus ticket_lotterie_status);

    List<UserTicket> findByUserId(UUID userId);
}