package com.api.guolo_api.adminMangement.domain.service;

import com.api.guolo_api.adminMangement.application.in.TicketUseCase;
import com.api.guolo_api.adminMangement.application.out.TicketOutputPort;
import com.api.guolo_api.adminMangement.domain.model.BuyTicketRequest;
import com.api.guolo_api.adminMangement.domain.model.TicketDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TicketService implements TicketUseCase {

    private final TicketOutputPort ticketOutputPort;

    @Override
    public TicketDto buyTicket(BuyTicketRequest request) {
        return ticketOutputPort.buyTicket(request);
    }

    @Override
    public List<TicketDto> fetchByLotteryId(UUID lotteryId) {
        return ticketOutputPort.fetchByLotteryId(lotteryId);
    }

    @Override
    public List<TicketDto> saveAll(List<TicketDto> ticketDtos) {
        return ticketOutputPort.saveAll(ticketDtos);
    }
}
