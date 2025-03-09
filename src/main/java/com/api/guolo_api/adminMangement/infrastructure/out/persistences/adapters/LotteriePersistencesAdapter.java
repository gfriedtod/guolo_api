package com.api.guolo_api.adminMangement.infrastructure.out.persistences.adapters;

import com.api.guolo_api.Entity.*;
import com.api.guolo_api.adminMangement.application.out.LotterieOutputPort;
import com.api.guolo_api.adminMangement.domain.model.*;
import com.api.guolo_api.adminMangement.infrastructure.out.persistences.repository.LotterieRepository;
import com.api.guolo_api.adminMangement.infrastructure.out.persistences.repository.LotteryViewRepository;
import com.api.guolo_api.adminMangement.infrastructure.out.persistences.repository.TicketRepository;
import com.api.guolo_api.adminMangement.infrastructure.out.persistences.repository.UserTicketRepository;
import com.api.guolo_api.mail.domain.dto.MessagePublisher;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class LotteriePersistencesAdapter implements LotterieOutputPort {
    private final LotterieRepository lotterieRepository;
    private final LotteryViewRepository lotteryViewRepository;
    private final ModelMapper mapper;
    private final TicketRepository ticketRepository;
    private final UserTicketRepository userTicketRepository;
    MessagePublisher messagePublisher;

    @Override
    public List<LotteryViewDto> fetchAll() {
        return lotteryViewRepository.findAll().stream().map((element) -> mapper.map(element, LotteryViewDto.class)).collect(Collectors.toList());
    }

    @Override
    public LotterieDto save(LotterieDto lotterieDto) {
        System.out.println(lotterieDto.getTickets().toArray().length);
        var lotterie = lotteryMapperToEntity(lotterieDto);
        lotterie.setStatus(LotteryStatus.created);
        lotterie =  lotterieRepository.save(lotterie);
        Lotterie finalLotterie = lotterie;
     var  tickets =  ticketRepository.saveAll(
                lotterieDto.getTickets().stream().map(
                        (element) -> Ticket.builder()
                                .id(element.getId())
                                .number(element.getNumber())
                                .price(element.getPrice())
                                .lotterie(finalLotterie)
                                .status(TicketStatus.pending)
                                .winner(false)
                                .build()

                ).collect(Collectors.toList())
        );
     lotterie.setTickets(new HashSet<>((tickets)));
     messagePublisher.sendMessage("A new lottery was created with name " + lotterie.getName());
        return lotteryMapperToDto(lotterie);
    }

    private LotterieDto lotteryMapperToDto(Lotterie lotterie) {
        return LotterieDto.builder()
                .name(lotterie.getName())
                .cashPrize(lotterie.getCashPrize())
                .admin(mapper.map(lotterie.getAdmin(), UserDto.class))
                .hour(lotterie.getHour())
                .startedDate(lotterie.getStartedDate())
                .endDate(lotterie.getEndDate())
                .status(lotterie.getStatus())
                .tickets(
                        lotterie.getTickets().stream().map(
                                (element) -> TicketDto.builder()
                                        .id(element.getId())
                                        .number(element.getNumber())
                                        .price(element.getPrice())
                                        .build()
                        ).collect(Collectors.toSet())

                )
                .build();
    }
    private LotterieDto lotteryMapperToDtoWithOutTickets(Lotterie lotterie) {
        return LotterieDto.builder()
                .name(lotterie.getName())
                .cashPrize(lotterie.getCashPrize())
                .admin(mapper.map(lotterie.getAdmin(), UserDto.class))
                .hour(lotterie.getHour())
                .startedDate(lotterie.getStartedDate())
                .endDate(lotterie.getEndDate())
                .status(lotterie.getStatus())
                .build();
    }

    private Lotterie lotteryMapperToEntity(LotterieDto lotterieDto) {
        return Lotterie.builder()
                .id(lotterieDto.getId())
                .name(lotterieDto.getName())
                .cashPrize(lotterieDto.getCashPrize())
                .admin(mapper.map(lotterieDto.getAdmin(), User.class))
                .hour(lotterieDto.getHour())
                .startedDate(lotterieDto.getStartedDate())
                .endDate(lotterieDto.getEndDate())
                .status(lotterieDto.getStatus())
                .build();
    }

    @Override
    public LotterieDto update(LotterieDto lotterieDto) {
        var lotterie = lotteryMapperToEntity(lotterieDto);
        lotterie =  lotterieRepository.save(lotterie);
                                                                                                                                                                                                    return lotteryMapperToDtoWithOutTickets(lotterie);
    }

    @Override
    public List<TicketDto> fetchByLotteryId(UUID lotteryId) {
        return List.of();
    }

    @Override
    public Winner draw(UUID lotteryId) {

       List<Ticket> tickets = ticketRepository.findByLotterie_IdAndLotterie_Status(lotteryId, LotteryStatus.created);

       if(tickets.isEmpty()){
        Ticket ticket  = ticketRepository.findByLotterie_IdAndWinnerTrue(lotteryId).orElse(null);
           assert ticket != null;
           return getWinner(ticket);
       }
        Random random = new Random();
        Ticket ticket = tickets.get(random.nextInt(tickets.size()));
        ticket.setWinner(true);
        Lotterie lotterie = ticket.getLotterie();
        lotterie.setStatus(LotteryStatus.ended);
        lotterieRepository.save(lotterie);
        ticket = ticketRepository.save(ticket);

        messagePublisher.sendMessage("The winner for lottery " + lotterie.getName() + " is " + ticket.getNumber(), "notification-"+lotterie.getId().toString());
        return getWinner(ticket);
    }

    private Winner getWinner(Ticket ticket) {
        Optional<UserTicket> user  =   userTicketRepository.findByTicket_Id(ticket.getId());

        if (user.isPresent()){
            return Winner.builder().ticketDto(TicketDto.builder().id(ticket.getId()).number(ticket.getNumber()).price(ticket.getPrice()).winner(ticket.getWinner()).build()).userDto(mapper.map(user.get().getUser(), UserDto.class)).build();
        }

        return Winner.builder().ticketDto(TicketDto.builder().id(ticket.getId()).number(ticket.getNumber()).price(ticket.getPrice()).winner(ticket.getWinner()).build()).build() ;
    }

    @Override
    public LotterieDto findById(UUID lotteryId) {

       Lotterie lotterie = lotterieRepository.findById(lotteryId).orElse(null);
        assert lotterie != null;
        return lotteryMapperToDto(lotterie);
    }

    @Override
    public LotterieDto delete(LotterieDto lotterieDto) {
        System.out.println(lotterieDto.getTickets().toArray().length);
        var lotterie = lotteryMapperToEntity(lotterieDto);
        lotterieRepository.delete(lotterie);

        return lotterieDto;
    }
}
