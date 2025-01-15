package com.api.guolo_api.adminMangement.application.out;

import com.api.guolo_api.userManagement.domain.model.TicketDto;

import java.util.List;

public interface TicketOutputPort {

    public TicketDto buyTicket(TicketDto ticketDto);

    public List<TicketDto> saveAll(List<TicketDto> ticketDtos);
}
