package com.api.guolo_api.adminMangement.infrastructure.out.persistences.adapters;

import com.api.guolo_api.Entity.Lotterie;
import com.api.guolo_api.adminMangement.application.out.LotterieOutputPort;
import com.api.guolo_api.adminMangement.infrastructure.out.persistences.repository.LotterieRepository;
import com.api.guolo_api.userManagement.domain.model.LotterieDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class LotteriePersistencesAdapter implements LotterieOutputPort {
    private final LotterieRepository lotterieRepository;
    private final ModelMapper mapper;

    @Override
    public List<LotterieDto> fetchAll() {
        return List.of();
    }

    @Override
    public LotterieDto save(LotterieDto lotterieDto) {
        return mapper.map(lotterieRepository.save(mapper.map(lotterieDto, Lotterie.class)), LotterieDto.class);
    }

    @Override
    public LotterieDto update(LotterieDto lotterieDto) {
        return mapper.map(lotterieRepository.saveAndFlush(mapper.map(lotterieDto, Lotterie.class)), LotterieDto.class);
    }
}
