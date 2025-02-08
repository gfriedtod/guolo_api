package com.api.guolo_api.adminMangement.domain.model;

import com.api.guolo_api.userManagement.domain.model.LotterieDto;
import com.api.guolo_api.userManagement.domain.model.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.api.guolo_api.Entity.PaymentRequest}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentRequestDto implements Serializable {
    private UUID id;
    private LotterieDto idLottery;
    private UserDto idUser;
    private String name;
    private String account;
    private String banck;
}