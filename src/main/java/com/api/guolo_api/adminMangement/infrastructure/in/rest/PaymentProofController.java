package com.api.guolo_api.adminMangement.infrastructure.in.rest;

import com.api.guolo_api.adminMangement.application.in.PaymentProofUseCase;
import com.api.guolo_api.adminMangement.domain.model.PaymentProofDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("admin/paymentProof")
@CrossOrigin("*")
@AllArgsConstructor
public class PaymentProofController {

    PaymentProofUseCase paymentProofUseCase;

    @PostMapping("")
    public ResponseEntity<?> savePaymentProof(@RequestBody PaymentProofDto paymentProofDto) {

        try {
            paymentProofUseCase.save(paymentProofDto);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            log.error(e.toString());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("lottery/{id}")
    public ResponseEntity<?> getPaymentProof(@PathVariable UUID id) {

        try {
            return ResponseEntity.ok(paymentProofUseCase.findByIdLottery(id));
        } catch (Exception e) {
            log.error(e.toString());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
