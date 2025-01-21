package com.api.guolo_api.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "ticket")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private UUID id;


    @Column(name = "number", nullable = false)
    private Short number;

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
    @ColumnDefault("'pending'")
    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ticketstatus")
    private TicketStatus status;

    @ColumnDefault("false")
    @Column(name = "winner", nullable = false)
    private Boolean winner = false;

}