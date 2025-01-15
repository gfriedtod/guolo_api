package com.api.guolo_api.adminMangement.domain.model;

import com.api.guolo_api.userManagement.domain.model.LotterieDto;
import com.api.guolo_api.userManagement.domain.model.TicketIdDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class TicketDto implements Serializable {
    private TicketIdDto id;
    private OffsetDateTime createdAt;
    private LotterieDto lotterie;
    private Double price;
}