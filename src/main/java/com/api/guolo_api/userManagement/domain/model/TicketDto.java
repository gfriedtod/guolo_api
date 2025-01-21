package com.api.guolo_api.userManagement.domain.model;

import com.api.guolo_api.Entity.TicketStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * DTO for {@link com.api.guolo_api.Entity.Ticket}
 */
@Data
@AllArgsConstructor(onConstructor = @__({@Deprecated}),access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class TicketDto implements Serializable {
    private UUID id;
    private Short number;
    @JsonIgnoreProperties("tickets")
    @EqualsAndHashCode.Exclude
    private LotterieDto lotterie;
    private Double price;
    private TicketStatus status;
    private Boolean winner = false;
}