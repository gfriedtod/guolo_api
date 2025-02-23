package com.api.guolo_api.mail.domain.dto;

import com.api.guolo_api.adminMangement.domain.model.UserDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmailRequest {

    private String to;
    private String subject;
    private String message;
    private String from;
    private UserDto userDto;

}
