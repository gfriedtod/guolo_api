package com.api.guolo_api.userManagement.application.out;

import com.api.guolo_api.userManagement.domain.model.UserPaymentRequestDto;

public interface UserPaymentRequestOutputPort {
    void save(UserPaymentRequestDto paymentRequest);
}
