package com.api.guolo_api.mail.domain.dto;


import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessagePublisher {

    private RabbitTemplate rabbitTemplate;
    private  AmqpAdmin rabbitAdmin;


    @Bean
    String declareQueue() {
       return rabbitAdmin.declareQueue(new Queue("admin"));
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("8c492d2f-7bfe-4d9b-9e42-0c2711031ae7", message.toString());
        rabbitTemplate.convertAndSend("notification-8c492d2f-7bfe-4d9b-9e42-0c2711031ae7", message.toString());

    }
}
