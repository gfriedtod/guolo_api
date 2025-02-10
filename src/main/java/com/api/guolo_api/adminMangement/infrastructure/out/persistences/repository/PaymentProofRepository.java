package com.api.guolo_api.adminMangement.infrastructure.out.persistences.repository;

import com.api.guolo_api.Entity.PaymentProof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PaymentProofRepository extends JpaRepository<PaymentProof, UUID> {
    List<PaymentProof> findByIdLotteryId(UUID idLottery);

    @Query("select p from PaymentProof p where p.idLottery.id = ?1")
    Optional<List<PaymentProof>>findByIdLottery_Id(UUID id);
}