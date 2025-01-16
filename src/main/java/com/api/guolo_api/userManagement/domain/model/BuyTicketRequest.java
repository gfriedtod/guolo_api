package com.api.guolo_api.userManagement.domain.model;

import com.api.guolo_api.userManagement.domain.model.TicketDto;
import com.api.guolo_api.userManagement.domain.model.UserDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BuyTicketRequest {
    UserDto userDto;
    List<TicketDto> ticketDtos;

}
