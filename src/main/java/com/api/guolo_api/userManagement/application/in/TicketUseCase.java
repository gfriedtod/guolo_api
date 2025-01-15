package com.api.guolo_api.userManagement.application.in;

import com.api.guolo_api.userManagement.domain.model.TicketDto;

public interface TicketUseCase {

    public TicketDto buyTicket(TicketDto ticketDto);
}
