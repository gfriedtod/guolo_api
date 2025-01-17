package com.api.guolo_api.userManagement.application.out;

import com.api.guolo_api.userManagement.domain.model.BuyTicketRequest;
import com.api.guolo_api.userManagement.domain.model.LotteryTicket;
import com.api.guolo_api.userManagement.domain.model.TicketDto;

import java.util.List;
import java.util.UUID;

public interface UserTicketOutputPort {
    public List<TicketDto> buyTicket(BuyTicketRequest request);
    public List<LotteryTicket> fetchByUserId(UUID lotteryId);
    public List<TicketDto> getATicket(UUID lotteryId, int number);

}
