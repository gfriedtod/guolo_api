package com.api.guolo_api.adminMangement.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuyTicketRequest {
    UserDto userDto;
    TicketDto ticketDto;

}
