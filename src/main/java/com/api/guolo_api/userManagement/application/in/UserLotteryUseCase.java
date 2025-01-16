package com.api.guolo_api.userManagement.application.in;

import com.api.guolo_api.userManagement.domain.model.LotterieDto;

import java.util.List;

public interface UserLotteryUseCase {

     List<LotterieDto> fetchAll();

}
