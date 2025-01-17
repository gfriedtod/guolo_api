package com.api.guolo_api.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Immutable;

import java.util.UUID;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@Entity
@Immutable
@Table(name = "lottery_view")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LotteryView {
    @Id
    private UUID id;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "cash_prize")
    private Double cashPrize;

    @Column(name = "nbre_ticker")
    private Long nbreTicker;
    @Column(name = "total_sale")
    private Long totalSale;


/*
 TODO [Reverse Engineering] create field to map the 'status' column


 Available actions: Define target Java type | Uncomment as is | Remove column mapping
 */
@Enumerated(EnumType.STRING)
@Column(name = "status", columnDefinition = "lotterystatus")
    private LotteryStatus status;
}