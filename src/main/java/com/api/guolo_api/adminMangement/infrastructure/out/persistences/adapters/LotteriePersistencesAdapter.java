package com.api.guolo_api.adminMangement.infrastructure.out.persistences.adapters;

import com.api.guolo_api.Entity.Lotterie;
import com.api.guolo_api.adminMangement.application.out.LotterieOutputPort;
import com.api.guolo_api.adminMangement.domain.model.LotteryViewDto;
import com.api.guolo_api.adminMangement.domain.model.TicketDto;
import com.api.guolo_api.adminMangement.infrastructure.out.persistences.repository.LotterieRepository;
import com.api.guolo_api.adminMangement.infrastructure.out.persistences.repository.LotteryViewRepository;
import com.api.guolo_api.userManagement.domain.model.LotterieDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class LotteriePersistencesAdapter implements LotterieOutputPort {
    private final LotterieRepository lotterieRepository;
    private final LotteryViewRepository lotteryViewRepository;
    private final ModelMapper mapper;

    @Override
    public List<LotteryViewDto> fetchAll() {
        return lotteryViewRepository.findAll().stream().map((element) -> mapper.map(element, LotteryViewDto.class)).collect(Collectors.toList());
    }

    @Override
    public LotterieDto save(LotterieDto lotterieDto) {

        return mapper.map(lotterieRepository.save(mapper.map(lotterieDto, Lotterie.class)), LotterieDto.class);
    }

    @Override
    public LotterieDto update(LotterieDto lotterieDto) {
        return mapper.map(lotterieRepository.saveAndFlush(mapper.map(lotterieDto, Lotterie.class)), LotterieDto.class);
    }

    @Override
    public List<TicketDto> fetchByLotteryId(UUID lotteryId) {
        return List.of();
    }

    @Override
    public LotterieDto delete(LotterieDto lotterieDto) {

        lotterieRepository.delete(mapper.map(lotterieDto, Lotterie.class));

        return lotterieDto;
    }
}
