package com.api.guolo_api.userManagement.infrastructure.in.rest;

import com.api.guolo_api.adminMangement.domain.model.BuyTicketRequest;
import com.api.guolo_api.userManagement.application.in.UserLotteryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("user/lottery")
@AllArgsConstructor
public class UserLotteryController {

    private final UserLotteryUseCase userLotteryUseCase;

    @GetMapping("")
    public ResponseEntity<?> getAllLotteries() {
        try {
            return ResponseEntity.ok(userLotteryUseCase.fetchAll());
        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }





}
