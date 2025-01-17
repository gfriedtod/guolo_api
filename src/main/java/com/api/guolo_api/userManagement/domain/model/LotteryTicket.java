package com.api.guolo_api.userManagement.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LotteryTicket {
    LotterieDto lotterieDto;
    List<TicketDto> tickets;
}
