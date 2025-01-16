package com.api.guolo_api.userManagement.domain.service;

import com.api.guolo_api.userManagement.application.in.UserLotteryUseCase;
import com.api.guolo_api.userManagement.application.out.UserLotteryOutputPort;
import com.api.guolo_api.userManagement.domain.model.LotterieDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserLotteryService implements UserLotteryUseCase {
    private final UserLotteryOutputPort outputPort;
    @Override
    public List<LotterieDto> fetchAll() {
        return outputPort.fetchAll();
    }
}
