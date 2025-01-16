package com.api.guolo_api.adminMangement.application.out;

import com.api.guolo_api.adminMangement.domain.model.LotteryViewDto;
import com.api.guolo_api.adminMangement.domain.model.TicketDto;
import com.api.guolo_api.userManagement.domain.model.LotterieDto;

import java.util.List;
import java.util.UUID;

public interface LotterieOutputPort {

    public List<LotteryViewDto> fetchAll();
    public LotterieDto save(LotterieDto lotterieDto);
    public LotterieDto update(LotterieDto lotterieDto);
    public List<TicketDto> fetchByLotteryId(UUID lotteryId);

    LotterieDto delete(LotterieDto lotterieDto);
}
