package com.api.guolo_api.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
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
public class LotteryView {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;;

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
    @Column(name = "status", columnDefinition = "lotterystatus")
    private Object status;
*/
}