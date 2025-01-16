package com.api.guolo_api.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "lotterie")
public class Lotterie {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = true)
    private UUID id;

    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "started_date", nullable = false)
    private LocalDate startedDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("gen_random_uuid()")
    @JoinColumn(name = "admin")
    private User admin;

    @ColumnDefault("'0'")
    @Column(name = "cash_prize")
    private Double cashPrize;

/*
 TODO [Reverse Engineering] create field to map the 'status' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
   */
    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "lotterystatus not null")
        private LotteryStatus status;

    @ColumnDefault("'10:00:00'")
    @Column(name = "hour")
    private LocalTime hour;

    @OneToMany(mappedBy = "lotterie")
    private Set<Ticket> tickets = new LinkedHashSet<>();

}

