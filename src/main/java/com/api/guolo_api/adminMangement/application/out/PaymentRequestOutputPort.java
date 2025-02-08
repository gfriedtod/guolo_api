package com.api.guolo_api.adminMangement.application.out;

import com.api.guolo_api.Entity.PaymentRequest;
import com.api.guolo_api.adminMangement.domain.model.PaymentRequestDto;

import java.util.List;
import java.util.UUID;

public interface PaymentRequestOutputPort {
    void save(PaymentRequestDto paymentRequest);
    List<PaymentRequestDto> findByUserId(UUID id); //PaymentRequest findByUserId
}
