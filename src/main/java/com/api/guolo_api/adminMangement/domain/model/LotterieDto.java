package com.api.guolo_api.adminMangement.domain.model;

import com.api.guolo_api.userManagement.domain.model.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * DTO for {@link com.api.guolo_api.Entity.Lotterie}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class LotterieDto implements Serializable {
    private UUID id;
    private OffsetDateTime createdAt;
    private String name;
    private LocalDate startedDate;
    private LocalDate endDate;
    private UserDto admin;
    private String status;
}