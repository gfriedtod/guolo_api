package com.api.guolo_api.adminMangement.infrastructure.out.persistences.adapters;

import com.api.guolo_api.Entity.*;
import com.api.guolo_api.adminMangement.application.out.TicketOutputPort;
import com.api.guolo_api.adminMangement.domain.model.BuyTicketRequest;
import com.api.guolo_api.adminMangement.infrastructure.out.persistences.repository.TicketRepository;
import com.api.guolo_api.adminMangement.infrastructure.out.persistences.repository.UserTicketRepository;
import com.api.guolo_api.adminMangement.domain.model.TicketDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class TicketPersistenceAdapter implements TicketOutputPort {

    private final UserTicketRepository userTicketRepository;
    private final TicketRepository ticketRepository;
    private final ModelMapper mapper;

    @Override
    public TicketDto buyTicket(BuyTicketRequest request) {

        var id = request.getTicketDto().getId();
        Ticket ticket= ticketRepository.findById(id).orElse(null);
        if(ticket!=null){
            ticket.setStatus(TicketStatus.sold);
            ticket = ticketRepository.save(ticket);

            userTicketRepository.save(
                    UserTicket.builder()
                            .user(mapper.map(request.getUserDto(), User.class))
                            .ticket(ticket)
                            .build()
            );
        }else{
            throw new RuntimeException("Ticket not found");
        }
        return null;
    }

    @Override
    public List<TicketDto> fetchByLotteryId(UUID lotteryId) {
        return  ticketRepository.findByLotterieId(lotteryId).stream().map((element) -> mapper.map(element, TicketDto.class)).toList();
    }

    @Override
    public List<TicketDto> saveAll(List<TicketDto> ticketDtos) {

     var  tickets = ticketRepository.saveAll(
                ticketDtos.stream().map((element) -> mapper.map(element, Ticket.class)).toList());

        return tickets.stream().map((element) -> mapper.map(element, TicketDto.class)).toList();
    }
}
