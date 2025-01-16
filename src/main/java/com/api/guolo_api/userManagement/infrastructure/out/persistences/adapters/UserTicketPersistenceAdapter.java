package com.api.guolo_api.userManagement.infrastructure.out.persistences.adapters;

import com.api.guolo_api.Entity.*;
import com.api.guolo_api.userManagement.domain.model.BuyTicketRequest;
import com.api.guolo_api.userManagement.domain.model.TicketDto;
import com.api.guolo_api.userManagement.infrastructure.out.persistences.repository.UserUserUserTicketRepository;
import com.api.guolo_api.userManagement.application.out.UserTicketOutputPort;
import com.api.guolo_api.userManagement.infrastructure.out.persistences.repository.UserUserTicketRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UserTicketPersistenceAdapter implements UserTicketOutputPort {

    private final UserUserUserTicketRepository userUserUserTicketRepository;
    private final UserUserTicketRepository ticketRepository;
    private final ModelMapper mapper;

    @Override
    public TicketDto buyTicket(BuyTicketRequest request) {

        TicketId id = new TicketId();
        id.setId(request.getTicketDto().getId());
        id.setNumber(request.getTicketDto().getNumber());
        Ticket ticket= ticketRepository.findById(id).orElse(null);
        if(ticket!=null){
            ticket.setStatus(TicketStatus.sold);
            ticket = ticketRepository.save(ticket);

            userUserUserTicketRepository.save(
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
        return  ticketRepository.findByLotterieIdAndStatus(lotteryId,TicketStatus.pending).stream().map((element) -> mapper.map(element, TicketDto.class)).toList();
    }

    @Override
    public List<TicketDto> getATicket(UUID lotteryId, int numberMax) {
        List<Ticket> tickets = (List<Ticket>) this.ticketRepository.findByLotterieIdAndStatus(lotteryId,TicketStatus.pending);
        ///random tickets List
        Assert.isTrue(tickets.size() >= numberMax, "Not enough tickets");
        List<TicketDto> ticketDtos = new java.util.ArrayList<>();
        for(int i = 1; i <= numberMax; i++) {
            int randomIndex = (int) (Math.random() * tickets.size());
            TicketDto ticketDto = mapper.map(tickets.get(randomIndex), TicketDto.class);
            ticketDtos.add(ticketDto);
        }
        return ticketDtos;
    }


}
