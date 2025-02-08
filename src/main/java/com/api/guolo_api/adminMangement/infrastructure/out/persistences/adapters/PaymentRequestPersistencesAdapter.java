package com.api.guolo_api.adminMangement.infrastructure.out.persistences.adapters;

import com.api.guolo_api.Entity.Lotterie;
import com.api.guolo_api.Entity.PaymentRequest;
import com.api.guolo_api.Entity.User;
import com.api.guolo_api.adminMangement.application.out.PaymentRequestOutputPort;
import com.api.guolo_api.adminMangement.domain.model.PaymentRequestDto;
import com.api.guolo_api.adminMangement.infrastructure.out.persistences.repository.PaymentRequestRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Component
public class PaymentRequestPersistencesAdapter implements PaymentRequestOutputPort {
    private final PaymentRequestRepository paymentRequestRepository;
    private final ModelMapper modelMapper;

    @Override
    public void save(PaymentRequestDto paymentRequest) {
       try {
           paymentRequestRepository.save(PaymentRequest.builder()
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

    @Override
    public List<PaymentRequestDto> findByUserId(UUID id) {
        return paymentRequestRepository.findAllByIdUserId(id).stream().map((element) -> modelMapper.map(element, PaymentRequestDto.class)).toList();
    }
}
