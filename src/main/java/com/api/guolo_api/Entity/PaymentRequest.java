package com.api.guolo_api.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "payment_request")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lottery")
    private Lotterie idLottery;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_user")
    private User idUser;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "account", length = Integer.MAX_VALUE)
    private String account;

    @Column(name = "banck", length = Integer.MAX_VALUE)
    private String banck;

}