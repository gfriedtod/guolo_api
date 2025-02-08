package com.api.guolo_api.adminMangement.application.in;

import com.api.guolo_api.adminMangement.domain.model.PaymentRequestDto;

import java.util.List;
import java.util.UUID;

public interface PaymentRequestUseCase {
    void save(PaymentRequestDto paymentRequest);
    List<PaymentRequestDto> findByUserId(UUID id); //PaymentRequest findByUserId

}
