package com.api.guolo_api.userManagement.infrastructure.in.rest;

import com.api.guolo_api.mail.domain.dto.EmailRequest;
import com.api.guolo_api.mail.domain.service.MaileService;
import com.mailjet.client.errors.MailjetException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private  MaileService maileService;


    @PostMapping("")
    ResponseEntity<?> sendMessage(@RequestBody EmailRequest request) throws MailjetException {

        try{
            maileService.send(
                    EmailRequest.builder()
                            .message("<h1>Incident rencontrer par "+ request.getFrom()+"</h1>\n" +
                                    "\n" +
                                    "<p></p>\n" +
                                    "\n" +
                                    "<p><b>message</b>: " + request.getMessage()   + "</p>\n" +
                                    "\n" +
                                    "\n" )
                            .from(request.getFrom())
                            .subject("incident sur la plateforme")
                            .to("")
                            .build()
            );

            return ResponseEntity.ok(EmailRequest.builder()
                    .message(request.getMessage())
                    .from(request.getFrom())
                    .to("")
                    .build());
        } catch (Exception e){

            log.error(e.getMessage());

            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }

}
