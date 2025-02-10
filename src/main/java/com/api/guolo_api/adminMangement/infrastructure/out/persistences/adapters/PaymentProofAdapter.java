package com.api.guolo_api.adminMangement.infrastructure.out.persistences.adapters;

import com.api.guolo_api.Entity.Lotterie;
import com.api.guolo_api.Entity.PaymentProof;
import com.api.guolo_api.adminMangement.application.out.PaymentProofOutputPort;
import com.api.guolo_api.adminMangement.domain.model.PaymentProofDto;
import com.api.guolo_api.adminMangement.infrastructure.out.persistences.repository.PaymentProofRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class PaymentProofAdapter implements PaymentProofOutputPort {

    PaymentProofRepository repository;
    ModelMapper mapper;
    /**
     * @param paymentProofDto
     */
    @Override
    public void save(PaymentProofDto paymentProofDto) {

        System.out.println(paymentProofDto.getIdLottery().getId());
        repository.save(PaymentProof.builder().
                        idLottery(Lotterie.builder().id(paymentProofDto.getIdLottery().getId()).build())
                                .link(paymentProofDto.getLink())
                .build());

    }

    /**
     * @param idLottery
     * @return List<PaymentProof>
     */
    @Override
    public List<PaymentProofDto> findByIdLottery(UUID idLottery) {
        return repository.findByIdLottery_Id(idLottery).get().stream().map((element) -> mapper.map(element, PaymentProofDto.class)).toList();
    }
}
