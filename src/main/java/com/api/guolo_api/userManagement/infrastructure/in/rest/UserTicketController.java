package com.api.guolo_api.userManagement.infrastructure.in.rest;

import com.api.guolo_api.userManagement.domain.model.BuyTicketRequest;
import com.api.guolo_api.userManagement.application.in.UserTicketUseCase;
import com.api.guolo_api.userManagement.infrastructure.out.persistences.repository.UserUserTicketRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/user/ticket")
@AllArgsConstructor
public class UserTicketController {
    private final UserTicketUseCase userTicketUseCase;
    @GetMapping("{id}/{number}")
    public ResponseEntity<?> getAllTickets(@PathVariable UUID id, @PathVariable int number) {
        try {
            return ResponseEntity.ok(userTicketUseCase.getATicket(id, number));
        } catch (Exception e) {
            log.error(e.toString());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("running/{userId}")
    public ResponseEntity<?> getAllRunningTickets(@PathVariable UUID userId) {
        try {
            return ResponseEntity.ok(userTicketUseCase.fetchUserId(userId));
        } catch (Exception e) {
            log.error(e.toString());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @PostMapping("/buy")
    public ResponseEntity<?> buyTicket(@RequestBody BuyTicketRequest request) {
        try {
            return ResponseEntity.ok(userTicketUseCase.buyTicket(request));
        } catch (Exception e) {
            log.error(e.toString());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
