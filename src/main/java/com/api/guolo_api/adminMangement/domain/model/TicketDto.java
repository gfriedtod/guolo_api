package com.api.guolo_api.adminMangement.domain.model;

import com.api.guolo_api.userManagement.domain.model.LotterieDto;
import com.api.guolo_api.userManagement.domain.model.TicketIdDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * DTO for {@link com.api.guolo_api.Entity.Ticket}
 */
@Getter
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor(onConstructor = @__({@Deprecated}),access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class TicketDto implements Serializable {
    private Long id;
    private Short number;
    private OffsetDateTime createdAt;
    private LotterieDto lotterie;
    private Double price;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(Short number) {
        this.number = number;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setLotterie(LotterieDto lotterie) {
        this.lotterie = lotterie;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}