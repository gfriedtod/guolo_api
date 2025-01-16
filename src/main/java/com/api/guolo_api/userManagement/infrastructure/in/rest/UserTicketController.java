package com.api.guolo_api.userManagement.infrastructure.in.rest;

import com.api.guolo_api.userManagement.application.in.UserTicketUseCase;
import com.api.guolo_api.userManagement.infrastructure.out.persistences.repository.UserUserTicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
