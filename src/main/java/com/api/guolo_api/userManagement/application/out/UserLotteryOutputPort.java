package com.api.guolo_api.userManagement.application.out;

import com.api.guolo_api.userManagement.domain.model.LotterieDto;

import java.util.List;

public interface UserLotteryOutputPort {
     List<LotterieDto> fetchAll();

}
