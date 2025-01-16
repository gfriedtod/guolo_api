package com.api.guolo_api.adminMangement.infrastructure.out.persistences.repository;

import com.api.guolo_api.Entity.LotteryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LotteryViewRepository extends JpaRepository<LotteryView, UUID>, JpaSpecificationExecutor<LotteryView> {
}