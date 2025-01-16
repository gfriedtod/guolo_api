package com.api.guolo_api.userManagement.infrastructure.out.persistences.repository;

import com.api.guolo_api.Entity.Lotterie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface UserLotterieRepository extends JpaRepository<Lotterie, UUID>, JpaSpecificationExecutor<Lotterie> {
}