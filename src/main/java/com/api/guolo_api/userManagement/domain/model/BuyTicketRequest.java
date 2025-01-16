package com.api.guolo_api.userManagement.domain.model;

import com.api.guolo_api.adminMangement.domain.model.TicketDto;
import com.api.guolo_api.adminMangement.domain.model.UserDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuyTicketRequest {
    UserDto userDto;
    TicketDto ticketDto;

}
