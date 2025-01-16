package com.api.guolo_api.adminMangement.application.in;

import com.api.guolo_api.adminMangement.domain.model.BuyTicketRequest;
import com.api.guolo_api.adminMangement.domain.model.TicketDto;

import java.util.List;
import java.util.UUID;

public interface TicketUseCase {

    public TicketDto buyTicket(BuyTicketRequest request);
    public List<TicketDto> fetchByLotteryId(UUID lotteryId);
    public List<TicketDto> saveAll(List<TicketDto> ticketDtos);
}
