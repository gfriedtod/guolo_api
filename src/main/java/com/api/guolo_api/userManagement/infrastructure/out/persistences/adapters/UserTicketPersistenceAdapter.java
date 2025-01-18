package com.api.guolo_api.userManagement.infrastructure.out.persistences.adapters;

import com.api.guolo_api.Entity.*;
import com.api.guolo_api.userManagement.domain.model.BuyTicketRequest;
import com.api.guolo_api.userManagement.domain.model.LotterieDto;
import com.api.guolo_api.userManagement.domain.model.LotteryTicket;
import com.api.guolo_api.userManagement.domain.model.TicketDto;
import com.api.guolo_api.userManagement.infrastructure.out.persistences.repository.UserUserUserTicketRepository;
import com.api.guolo_api.userManagement.application.out.UserTicketOutputPort;
import com.api.guolo_api.userManagement.infrastructure.out.persistences.repository.UserUserTicketRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.*;

@Component
@AllArgsConstructor
public class UserTicketPersistenceAdapter implements UserTicketOutputPort {

    private final UserUserUserTicketRepository userUserUserTicketRepository;
    private final UserUserTicketRepository ticketRepository;
    private final ModelMapper mapper;

    @Override
    public List<TicketDto> buyTicket(BuyTicketRequest request) {

        for (TicketDto ticketDto : request.getTicketDtos()) {
            System.out.println(ticketDto.getId());
            Ticket ticket= ticketRepository.findById(ticketDto.getId()).orElse(null);
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

        return request.getTicketDtos();
    }

    @Override
    public List<LotteryTicket> fetchByUserId(UUID userId) {
        List<LotteryTicket> list = new ArrayList<>();
        HashSet<Object> id = new HashSet<>();
        var tickets  =  userUserUserTicketRepository.findByUserIdAndTicketLotterieStatus(userId,LotteryStatus.created).stream().map((element) -> mapper.map(element, UserTicket.class)).toList();
        tickets.forEach(element -> {
            id.add(element.getTicket().getLotterie().getId()
            );
        });
        id.forEach(
                ids->{

                    var   elTickets = tickets.stream().filter(sub -> sub.getTicket().getLotterie().getId().equals(ids)).toList();
                    list.add(LotteryTicket.builder().tickets(elTickets.stream().map(sub2 -> TicketDto.builder().id(sub2.getTicket().getId()).number(sub2.getTicket().getNumber()).price(sub2.getTicket().getPrice()).status(sub2.getTicket().getStatus()).build()).toList()).lotterieDto(mapper.map(elTickets.getFirst().getTicket().getLotterie(), LotterieDto.class)).build());

                }
        );
        return list;
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
                    id(tickets.get(randomIndex).getId())
                    .number(tickets.get(randomIndex).getNumber())
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
