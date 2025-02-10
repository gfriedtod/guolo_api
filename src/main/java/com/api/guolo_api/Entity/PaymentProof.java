package com.api.guolo_api.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "payment_proof")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentProof {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "link")
    private String link;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lottery")
    private Lotterie idLottery;

    @ColumnDefault("'preuve de paiement'")
    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

}