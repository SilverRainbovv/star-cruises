package com.didenko.starcruises.entity;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(exclude = {"seat", "client"})
@ToString(exclude = {"seat", "client"})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {

    @Id
    private Long id;

    @ManyToOne
    private Cruise cruise;

    @OneToOne
    private Seat seat;

    @OneToOne
    private Client client;

    @Enumerated(EnumType.STRING)
    private TicketState state;

}
