package com.api.guolo_api.adminMangement.infrastructure.in.rest;

import com.api.guolo_api.adminMangement.application.in.PaymentRequestUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("admin/paymentRequest")
@AllArgsConstructor
public class PaymentRequestController {

    private PaymentRequestUseCase userPaymentRequestUseCase;


    @GetMapping("{id}")
    public ResponseEntity<?> getPaymentRequest(@PathVariable String id) {
        try {
            return ResponseEntity.ok(userPaymentRequestUseCase.findByUserId(UUID.fromString(id)));
        } catch (Exception e) {
            log.error(e.toString());

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
