package com.api.guolo_api.adminMangement.application.in;

import com.api.guolo_api.userManagement.domain.model.TicketDto;

import java.util.List;

public interface TicketUseCase {

    public TicketDto buyTicket(TicketDto ticketDto);

    public List<TicketDto> saveAll(List<TicketDto> ticketDtos);
}
