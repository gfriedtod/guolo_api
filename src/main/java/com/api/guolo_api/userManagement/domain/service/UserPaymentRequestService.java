package com.api.guolo_api.userManagement.domain.service;

import com.api.guolo_api.userManagement.application.in.UserPaymentRequestUseCase;
import com.api.guolo_api.userManagement.application.out.UserPaymentRequestOutputPort;
import com.api.guolo_api.userManagement.domain.model.UserPaymentRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserPaymentRequestService implements UserPaymentRequestUseCase {
    private final UserPaymentRequestOutputPort paymentRequestOutputPort;
    @Override
    public void save(UserPaymentRequestDto paymentRequest) {
        paymentRequestOutputPort.save(paymentRequest);

    }
}
