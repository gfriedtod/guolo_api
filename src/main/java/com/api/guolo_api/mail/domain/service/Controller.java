package com.api.guolo_api.mail.domain.service;

import com.api.guolo_api.mail.domain.dto.EmailRequest;
import com.api.guolo_api.mail.domain.dto.MessagePublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("mail")
@CrossOrigin("*")
@AllArgsConstructor
public class Controller {

    MessagePublisher messagePublisher;

    @PostMapping("/send")
    public void send(@RequestBody EmailRequest message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        messagePublisher.sendMessage(mapper.writeValueAsString(
                        message
                ),
                "notification-"+message.getTopic());
        messagePublisher.sendMessage(mapper.writeValueAsString(
                message
        ),
                message.getTopic());

    }
}
