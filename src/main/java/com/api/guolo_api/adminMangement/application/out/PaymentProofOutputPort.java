package com.api.guolo_api.adminMangement.application.out;

import com.api.guolo_api.Entity.PaymentProof;
import com.api.guolo_api.adminMangement.domain.model.PaymentProofDto;

import java.util.List;
import java.util.UUID;

public interface PaymentProofOutputPort {

    void save(PaymentProofDto paymentProofDto);
    List<PaymentProofDto> findByIdLottery(UUID idLottery);
}
