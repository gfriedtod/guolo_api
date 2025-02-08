package com.api.guolo_api.adminMangement.infrastructure.in.rest;

import com.api.guolo_api.adminMangement.application.in.PaymentRequestUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
