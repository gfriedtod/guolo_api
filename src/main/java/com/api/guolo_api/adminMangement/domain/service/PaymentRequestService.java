package com.api.guolo_api.adminMangement.domain.service;

import com.api.guolo_api.adminMangement.application.in.PaymentRequestUseCase;
import com.api.guolo_api.adminMangement.application.out.PaymentRequestOutputPort;
import com.api.guolo_api.adminMangement.domain.model.PaymentRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class PaymentRequestService implements PaymentRequestUseCase {
    private final PaymentRequestOutputPort paymentRequestOutputPort;
    @Override
    public void save(PaymentRequestDto paymentRequest) {
        paymentRequestOutputPort.save(paymentRequest);

    }

    @Override
    public List<PaymentRequestDto> findByUserId(UUID id) {
        return paymentRequestOutputPort.findByUserId(id);
    }
}
