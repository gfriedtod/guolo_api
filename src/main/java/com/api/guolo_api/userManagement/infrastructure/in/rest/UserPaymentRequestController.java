package com.api.guolo_api.userManagement.infrastructure.in.rest;

import com.api.guolo_api.userManagement.application.in.UserPaymentRequestUseCase;
import com.api.guolo_api.userManagement.domain.model.UserPaymentRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
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
            log.error(e.toString());

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
