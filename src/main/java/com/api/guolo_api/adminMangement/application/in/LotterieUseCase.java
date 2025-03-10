package com.api.guolo_api.adminMangement.application.in;

import com.api.guolo_api.adminMangement.domain.model.LotteryViewDto;
import com.api.guolo_api.adminMangement.domain.model.LotterieDto;
import com.api.guolo_api.adminMangement.domain.model.TicketDto;
import com.api.guolo_api.adminMangement.domain.model.Winner;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.UUID;

public interface LotterieUseCase {

    public List<LotteryViewDto> fetchAll();
    public LotterieDto save(LotterieDto lotterieDto) throws JsonProcessingException;
    public LotterieDto update(LotterieDto lotterieDto);
    LotterieDto findById(UUID lotteryId);
    LotterieDto delete(LotterieDto lotterieDto);
    public Winner draw(UUID lotteryId) throws JsonProcessingException;
}
