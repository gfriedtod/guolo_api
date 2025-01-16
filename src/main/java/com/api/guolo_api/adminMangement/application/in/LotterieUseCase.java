package com.api.guolo_api.adminMangement.application.in;

import com.api.guolo_api.adminMangement.domain.model.LotteryViewDto;
import com.api.guolo_api.userManagement.domain.model.LotterieDto;

import java.util.List;

public interface LotterieUseCase {

    public List<LotteryViewDto> fetchAll();
    public LotterieDto save(LotterieDto lotterieDto);
    public LotterieDto update(LotterieDto lotterieDto);

    LotterieDto delete(LotterieDto lotterieDto);
}
