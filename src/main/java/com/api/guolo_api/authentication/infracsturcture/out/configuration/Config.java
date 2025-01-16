package com.api.guolo_api.authentication.infracsturcture.out.configuration;


import com.api.guolo_api.Entity.Ticket;
import com.api.guolo_api.adminMangement.domain.model.TicketDto;
import com.api.guolo_api.authentication.domain.service.ClientService;
import com.api.guolo_api.authentication.domain.service.UserAuthService;
import com.api.guolo_api.authentication.infracsturcture.out.adapter.UserAuthPersistenceAdapter;
import com.api.guolo_api.authentication.infracsturcture.out.persitence.repository.UserAuthRepository;
import com.api.guolo_api.mail.domain.service.MaileService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config {

    @Bean
    UserAuthPersistenceAdapter userAuthPersistenceAdapter(UserAuthRepository userRepository, ModelMapper modelMapper){
        return new UserAuthPersistenceAdapter(userRepository,modelMapper);
    }


    @Bean
    ClientService clientService(UserAuthPersistenceAdapter userAuthPersistenceAdapter){
        return new ClientService(userAuthPersistenceAdapter);
    }

    @Bean
    UserAuthService userService(UserAuthPersistenceAdapter userAuthPersistenceAdapter, PasswordEncoder passwordEncoder, MaileService maileService){
        return  new UserAuthService(userAuthPersistenceAdapter,passwordEncoder,maileService);
    }

    @Bean
    ModelMapper mapper(){
        ModelMapper modelMapper = new ModelMapper();
//
//        modelMapper.getConfiguration()
//                .setSkipNullEnabled(true)
//                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PUBLIC)
//                .setFieldMatchingEnabled(true);
//
//
//        modelMapper.createTypeMap(
//
//                com.api.guolo_api.userManagement.domain.model.TicketDto.class,
//                com.api.guolo_api.Entity.Ticket.class
//
//        ).addMapping(
//                com.api.guolo_api.userManagement.domain.model.TicketDto::getId,
//                (Ticket ticket, TicketDto ticketDto) -> ticketDto.setId(ticket.getId().getId())
//        ).addMapping(
//                com.api.guolo_api.userManagement.domain.model.TicketDto::getNumber,
//                (Ticket ticket, TicketDto ticketDto) -> ticketDto.setNumber(ticket.getId().getNumber())
//        )
//
//        ;
        return  modelMapper;
    }

}
