package com.api.guolo_api.userManagement.infrastructure.out.persistences.repository;

import com.api.guolo_api.Entity.Lotterie;
import com.api.guolo_api.Entity.LotteryStatus;
import com.api.guolo_api.userManagement.domain.model.LotterieDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public interface UserLotterieRepository extends JpaRepository<Lotterie, UUID>, JpaSpecificationExecutor<Lotterie> {
    List<Lotterie> findByStatus(LotteryStatus lotteryStatus);
}