package com.api.guolo_api.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "ticket")
public class Ticket {
    @EmbeddedId
    private TicketId id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("gen_random_uuid()")
    @JoinColumn(name = "lotterie", nullable = false)
    private Lotterie lotterie;

    @Column(name = "price", nullable = false)
    private Double price;

/*
 TODO [Reverse Engineering] create field to map the 'status' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
   */
@Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ticketstatus")
    private TicketStatus status;
}
