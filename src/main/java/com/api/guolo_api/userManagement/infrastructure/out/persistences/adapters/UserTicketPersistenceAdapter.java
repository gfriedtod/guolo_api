package com.api.guolo_api.userManagement.infrastructure.out.persistences.adapters;

import com.api.guolo_api.Entity.*;
import com.api.guolo_api.userManagement.domain.model.BuyTicketRequest;
import com.api.guolo_api.userManagement.domain.model.LotterieDto;
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
        for (TicketDto ticketDto : request.getTicketDtos()) {
            id.setId(ticketDto.getId());
            id.setNumber(ticketDto.getNumber());
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
            } else {
                throw new RuntimeException("Ticket not found");
            }
        }
//        id.setId(request.getTicketDtos().getId());
//        id.setNumber(request.getTicketDtos().getNumber());
//        Ticket ticket= ticketRepository.findById(id).orElse(null);
//        if(ticket!=null){
//            ticket.setStatus(TicketStatus.sold);
//            ticket = ticketRepository.save(ticket);
//
//            userUserUserTicketRepository.save(
//                    UserTicket.builder()
//                            .user(mapper.map(request.getUserDto(), User.class))
//                            .ticket(ticket)
//                            .build()
//            );
//        }else{
//            throw new RuntimeException("Ticket not found");
//        }
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
            TicketDto ticketDto = TicketDto.builder().
                    id(tickets.get(randomIndex).getId().getId())
                    .number(tickets.get(randomIndex).getId().getNumber())
                            .lotterie(LotterieDto.builder().id(tickets.get(randomIndex).getLotterie().getId()).name(tickets.get(randomIndex).getLotterie().getName()).cashPrize(tickets.get(randomIndex).getLotterie().getCashPrize()).hour(tickets.get(randomIndex).getLotterie().getHour()).status(tickets.get(randomIndex).getLotterie().getStatus()).endDate(tickets.get(randomIndex).getLotterie().getEndDate()).startedDate(tickets.get(randomIndex).getLotterie().getStartedDate()).startedDate(tickets.get(randomIndex).getLotterie().getStartedDate()).build())
                    .price(tickets.get(randomIndex).getPrice())
                    .status(tickets.get(randomIndex).getStatus())
                                    .build();
            ticketDtos.add(ticketDto);
            tickets.remove(randomIndex);
        }
        return ticketDtos;
    }


}
