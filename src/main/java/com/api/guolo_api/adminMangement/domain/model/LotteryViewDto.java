package com.api.guolo_api.adminMangement.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.api.guolo_api.Entity.LotteryView}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class LotteryViewDto implements Serializable {
    private UUID id;
    private String name;
    private String status;
    private Double cashPrize;
    private Long nbreTicker;
    private Long totalSale;
}