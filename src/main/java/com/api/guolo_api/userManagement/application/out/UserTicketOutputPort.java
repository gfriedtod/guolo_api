package com.api.guolo_api.userManagement.application.out;

import com.api.guolo_api.userManagement.domain.model.BuyTicketRequest;
import com.api.guolo_api.userManagement.domain.model.TicketDto;

import java.util.List;
import java.util.UUID;

public interface UserTicketOutputPort {
    public TicketDto buyTicket(BuyTicketRequest request);
    public List<TicketDto> fetchByLotteryId(UUID lotteryId);
    public List<TicketDto> getATicket(UUID lotteryId, int number);

}
