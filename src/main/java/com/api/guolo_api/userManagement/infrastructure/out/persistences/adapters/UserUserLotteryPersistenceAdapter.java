package com.api.guolo_api.userManagement.infrastructure.out.persistences.adapters;

import com.api.guolo_api.Entity.LotteryStatus;
import com.api.guolo_api.userManagement.application.out.UserLotteryOutputPort;
import com.api.guolo_api.userManagement.domain.model.LotterieDto;
import com.api.guolo_api.userManagement.domain.model.TicketDto;
import com.api.guolo_api.userManagement.infrastructure.out.persistences.repository.UserLotterieRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

@Component
@AllArgsConstructor
public class UserUserLotteryPersistenceAdapter implements UserLotteryOutputPort {

    private final UserLotterieRepository userLotterieRepository;
    private final ModelMapper mapper;


    @Override
    public List<LotterieDto> fetchAll() {
        return userLotterieRepository.findByStatus(LotteryStatus.created).stream().map((element) -> LotterieDto.builder().id(element.getId()).name(element.getName()).hour( element.getHour()).endDate(element.getEndDate()).startedDate(element.getStartedDate()).cashPrize(element.getCashPrize()).tickets(new LinkedHashSet<>(Collections.singleton(element.getTickets().stream().findFirst().map(el -> TicketDto.builder().id(el.getId()).number(el.getNumber()).price(el.getPrice()).build()).get()))).build()).toList();
    }
}
