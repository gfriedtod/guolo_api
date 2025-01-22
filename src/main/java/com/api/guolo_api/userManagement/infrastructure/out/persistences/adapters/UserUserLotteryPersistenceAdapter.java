package com.api.guolo_api.userManagement.infrastructure.out.persistences.adapters;

import com.api.guolo_api.Entity.LotteryStatus;
import com.api.guolo_api.userManagement.application.out.UserLotteryOutputPort;
import com.api.guolo_api.userManagement.domain.model.LotterieDto;
import com.api.guolo_api.userManagement.infrastructure.out.persistences.repository.UserLotterieRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserUserLotteryPersistenceAdapter implements UserLotteryOutputPort {

    private final UserLotterieRepository userLotterieRepository;
    private final ModelMapper mapper;


    @Override
    public List<LotterieDto> fetchAll() {
        return userLotterieRepository.findByStatus(LotteryStatus.created).stream().map((element) -> mapper.map(element, LotterieDto.class)).toList();
    }
}
