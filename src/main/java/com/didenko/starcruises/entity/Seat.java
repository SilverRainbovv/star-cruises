package com.didenko.starcruises.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@EqualsAndHashCode(exclude = "ship")
@ToString(exclude = "ship")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Seat {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private Integer number;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Vacancy vacancy;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_class")
    private SeatClass seatClass;

    @ManyToOne
    private Ship ship;

    public void setShip(Ship ship) {
        this.ship = ship;
        ship.addSeat(this);
    }
}
