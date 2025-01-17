package com.api.guolo_api.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "user_ticket")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserTicket {
    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_ticket_id_gen")
    @SequenceGenerator(name = "user_ticket_id_gen", sequenceName = "user_ticket_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"user\"")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @ColumnDefault("gen_random_uuid()")
    @JoinColumn(name = "ticket")
    private Ticket ticket;

}