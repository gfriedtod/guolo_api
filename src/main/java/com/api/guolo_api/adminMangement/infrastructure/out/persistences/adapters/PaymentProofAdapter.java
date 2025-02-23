package com.api.guolo_api.adminMangement.infrastructure.out.persistences.adapters;

import com.api.guolo_api.Entity.*;
import com.api.guolo_api.adminMangement.application.out.PaymentProofOutputPort;
import com.api.guolo_api.adminMangement.domain.model.PaymentProofDto;
import com.api.guolo_api.adminMangement.domain.model.TicketDto;
import com.api.guolo_api.adminMangement.domain.model.UserDto;
import com.api.guolo_api.adminMangement.domain.model.Winner;
import com.api.guolo_api.adminMangement.infrastructure.out.persistences.repository.*;
import com.api.guolo_api.mail.domain.dto.MessagePublisher;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Component
@AllArgsConstructor
public class PaymentProofAdapter implements PaymentProofOutputPort {

    PaymentProofRepository repository;
    ModelMapper mapper;
    MessagePublisher messagePublisher;
    private final LotterieRepository lotterieRepository;
    private final LotteryViewRepository lotteryViewRepository;
    private final TicketRepository ticketRepository;
    private final UserTicketRepository userTicketRepository;

    /**
     * @param paymentProofDto
     */
    @Override
    public void save(PaymentProofDto paymentProofDto) {

       PaymentProof proof = repository.save(PaymentProof.builder().
                        idLottery(Lotterie.builder().id(paymentProofDto.getIdLottery().getId()).build())
                                .link(paymentProofDto.getLink())
                        .name(paymentProofDto.getName())
                .build());

       if(proof.getIdLottery().getStatus().equals(LotteryStatus.ended)){
           Winner winner = draw(proof.getIdLottery().getId());
           messagePublisher.sendMessage(
                   "A new proof as uploaded for the lottery " + proof.getIdLottery().getName(),
                   "notification-"+winner.getUserDto().getId().toString()

           );
       }


    }

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
        return getWinner(ticket);
    }
    private Winner getWinner(Ticket ticket) {
        Optional<UserTicket> user  =   userTicketRepository.findByTicket_Id(ticket.getId());

        if (user.isPresent()){
            return Winner.builder().ticketDto(TicketDto.builder().id(ticket.getId()).number(ticket.getNumber()).price(ticket.getPrice()).winner(ticket.getWinner()).build()).userDto(mapper.map(user.get().getUser(), UserDto.class)).build();
        }

        return Winner.builder().ticketDto(TicketDto.builder().id(ticket.getId()).number(ticket.getNumber()).price(ticket.getPrice()).winner(ticket.getWinner()).build()).build() ;
    }



    /**
     * @param idLottery
     * @return List<PaymentProof>
     */
    @Override
    public List<PaymentProofDto> findByIdLottery(UUID idLottery) {
        return repository.findByIdLottery_Id(idLottery).get().stream().map((element) -> mapper.map(element, PaymentProofDto.class)).toList();
    }
}
