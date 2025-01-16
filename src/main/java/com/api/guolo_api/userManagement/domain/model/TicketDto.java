package com.api.guolo_api.userManagement.domain.model;

import com.api.guolo_api.Entity.TicketStatus;
import com.api.guolo_api.adminMangement.domain.model.LotterieDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * DTO for {@link com.api.guolo_api.Entity.Ticket}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketDto implements Serializable {
    private Long id;
    private Short number;
    private OffsetDateTime createdAt;
    @JsonIgnoreProperties("tickets")
    private LotterieDto lotterie;
    private Double price;
    private TicketStatus status;
}