package com.api.guolo_api.userManagement.domain.model;

import com.api.guolo_api.Entity.LotteryStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link com.api.guolo_api.Entity.Lotterie}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LotterieDto implements Serializable {
    private UUID id;
    private OffsetDateTime createdAt;
    private String name;
    private LocalDate startedDate;
    private LocalDate endDate;
    private UserDto admin;
    private Double cashPrize;
    private LotteryStatus status;
    private LocalTime hour;
    @JsonIgnoreProperties("lotterie")
    private Set<TicketDto> tickets = new LinkedHashSet<>();
}