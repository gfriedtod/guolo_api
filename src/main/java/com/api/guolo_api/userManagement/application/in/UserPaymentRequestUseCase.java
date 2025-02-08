package com.api.guolo_api.userManagement.application.in;

import com.api.guolo_api.userManagement.domain.model.UserPaymentRequestDto;

public interface UserPaymentRequestUseCase {
    void save(UserPaymentRequestDto paymentRequest);
}
