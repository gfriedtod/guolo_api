package com.api.guolo_api.userManagement.domain.service;

import com.api.guolo_api.userManagement.domain.model.BuyTicketRequest;
import com.api.guolo_api.userManagement.domain.model.TicketDto;
import com.api.guolo_api.userManagement.application.in.UserTicketUseCase;
import com.api.guolo_api.userManagement.application.out.UserTicketOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserTicketService implements UserTicketUseCase {

    private final UserTicketOutputPort ticketOutputPort;

    @Override
    public TicketDto buyTicket(BuyTicketRequest request) {
        return ticketOutputPort.buyTicket(request);
    }

    @Override
    public List<TicketDto> fetchByLotteryId(UUID lotteryId) {
        return ticketOutputPort.fetchByLotteryId(lotteryId);
    }

    @Override
    public List<TicketDto> getATicket(UUID lotteryId, int number) {
        return ticketOutputPort.getATicket(lotteryId, number);
    }

}
