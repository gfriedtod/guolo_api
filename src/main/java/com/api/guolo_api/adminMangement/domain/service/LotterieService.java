package com.api.guolo_api.adminMangement.domain.service;

import com.api.guolo_api.adminMangement.application.in.LotterieUseCase;
import com.api.guolo_api.adminMangement.application.out.LotterieOutputPort;
import com.api.guolo_api.adminMangement.domain.model.LotteryViewDto;
import com.api.guolo_api.adminMangement.domain.model.LotterieDto;
import com.api.guolo_api.adminMangement.domain.model.TicketDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LotterieService implements LotterieUseCase {
    private final LotterieOutputPort outputPort;
    @Override
    public List<LotteryViewDto> fetchAll() {
        return this.outputPort.fetchAll();
    }

    @Override
    public LotterieDto save(LotterieDto lotterieDto) {
        return outputPort.save(lotterieDto);
    }

    @Override
    public LotterieDto update(LotterieDto lotterieDto) {
        return outputPort.update(lotterieDto);
    }

    @Override
    public LotterieDto findById(UUID lotteryId) {
        return outputPort.findById(lotteryId);
    }

    @Override
    public LotterieDto delete(LotterieDto lotterieDto) {
        return outputPort.delete(lotterieDto);
    }

    @Override
    public TicketDto draw(UUID lotteryId) {
        return outputPort.draw(lotteryId);
    }
}
