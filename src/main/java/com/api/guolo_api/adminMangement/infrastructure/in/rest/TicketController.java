package com.api.guolo_api.adminMangement.infrastructure.in.rest;

import com.api.guolo_api.adminMangement.application.in.TicketUseCase;
import com.api.guolo_api.adminMangement.domain.model.BuyTicketRequest;
import com.api.guolo_api.adminMangement.domain.model.TicketDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/ticket")
@Slf4j
public class TicketController {

    private final TicketUseCase ticketUseCase;

    @PatchMapping("")
    public ResponseEntity<?> buyTicket(@RequestBody BuyTicketRequest request) {
        try {
            return ResponseEntity.ok(ticketUseCase.buyTicket(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity<?> saveTicket(@RequestBody List<TicketDto> ticketDtos) {
        try {
            return ResponseEntity.ok(ticketUseCase.saveAll(ticketDtos));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAllTickets(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(ticketUseCase.fetchByLotteryId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
