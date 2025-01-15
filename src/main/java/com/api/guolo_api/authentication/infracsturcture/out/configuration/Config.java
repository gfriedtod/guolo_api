package com.api.guolo_api.authentication.infracsturcture.out.configuration;


import com.api.guolo_api.authentication.domain.service.ClientService;
import com.api.guolo_api.authentication.domain.service.UserAuthService;
import com.api.guolo_api.authentication.infracsturcture.out.adapter.UserAuthPersistenceAdapter;
import com.api.guolo_api.authentication.infracsturcture.out.persitence.repository.UserAuthRepository;
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
    UserAuthService userService(UserAuthPersistenceAdapter userAuthPersistenceAdapter, PasswordEncoder passwordEncoder){
        return  new UserAuthService(userAuthPersistenceAdapter,passwordEncoder);
    }

    @Bean
    ModelMapper mapper(){
        return  new ModelMapper();
    }

}
