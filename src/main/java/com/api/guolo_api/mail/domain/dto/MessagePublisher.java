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

        rabbitAdmin.declareQueue(new Queue("general"));
        return rabbitAdmin.declareQueue(new Queue("admin"));
    }

    public void sendMessage(String message,String key) {
        rabbitTemplate.convertAndSend(key, message);
        if (key.contains("notification")){
            rabbitTemplate.convertAndSend(key, message);
        }
//        rabbitTemplate.convertAndSend(key, message);

    }
}
