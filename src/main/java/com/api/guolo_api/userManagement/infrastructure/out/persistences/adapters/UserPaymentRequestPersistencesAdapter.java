package com.api.guolo_api.userManagement.infrastructure.out.persistences.adapters;

import com.api.guolo_api.Entity.Lotterie;
import com.api.guolo_api.Entity.PaymentRequest;
import com.api.guolo_api.Entity.User;
import com.api.guolo_api.userManagement.application.out.UserPaymentRequestOutputPort;
import com.api.guolo_api.userManagement.domain.model.UserPaymentRequestDto;
import com.api.guolo_api.userManagement.infrastructure.out.persistences.repository.UserPaymentRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserPaymentRequestPersistencesAdapter implements UserPaymentRequestOutputPort {
    private final UserPaymentRequestRepository userPaymentRequestRepository;
    @Override
    public void save(UserPaymentRequestDto paymentRequest) {
       try {
           userPaymentRequestRepository.save(PaymentRequest.builder()
                   .idUser(User.builder()
                           .id(paymentRequest.getIdUser().getId()).build())
                   .idLottery(Lotterie.builder()
                           .id(paymentRequest.getIdLottery().getId())
                           .build())
                   .banck(paymentRequest.getBanck())
                   .account(paymentRequest.getAccount())
                   .name(paymentRequest.getName())
                   .build());
       } catch (Exception e) {
           throw new RuntimeException(e);
       }

    }
}
