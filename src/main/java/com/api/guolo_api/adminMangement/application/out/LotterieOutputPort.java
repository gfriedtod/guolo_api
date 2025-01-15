package com.api.guolo_api.adminMangement.application.out;

import com.api.guolo_api.userManagement.domain.model.LotterieDto;

import java.util.List;

public interface LotterieOutputPort {

    public List<LotterieDto> fetchAll();
    public LotterieDto save(LotterieDto lotterieDto);
    public LotterieDto update(LotterieDto lotterieDto);

}
