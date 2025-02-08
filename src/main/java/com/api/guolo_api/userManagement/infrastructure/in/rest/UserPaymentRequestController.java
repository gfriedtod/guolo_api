package com.api.guolo_api.userManagement.infrastructure.in.rest;

import com.api.guolo_api.userManagement.application.in.UserPaymentRequestUseCase;
import com.api.guolo_api.userManagement.domain.model.UserPaymentRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/paymentRequest")
@AllArgsConstructor
public class UserPaymentRequestController {

    private UserPaymentRequestUseCase userPaymentRequestUseCase;

    @PostMapping("")
    public ResponseEntity<?> savePaymentRequest(@RequestBody UserPaymentRequestDto paymentRequest) {
        try {
            userPaymentRequestUseCase.save(paymentRequest);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
