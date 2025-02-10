package com.api.guolo_api.adminMangement.domain.service;

import com.api.guolo_api.Entity.PaymentProof;
import com.api.guolo_api.adminMangement.application.in.PaymentProofUseCase;
import com.api.guolo_api.adminMangement.application.out.PaymentProofOutputPort;
import com.api.guolo_api.adminMangement.domain.model.PaymentProofDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PaymentProofService implements PaymentProofUseCase {

    PaymentProofOutputPort port;

    /**
     * @param paymentProofDto
     */
    @Override
    public void save(PaymentProofDto paymentProofDto) {
        port.save(paymentProofDto);
    }

    /**
     * @param idLottery
     * @return List<PaymentProof>
     */
    @Override
    public List<PaymentProofDto> findByIdLottery(UUID idLottery) {
        return port.findByIdLottery(idLottery);
    }
}
