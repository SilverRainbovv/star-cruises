package com.didenko.starcruises.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(exclude = {"seats", "cruises"})
@ToString(exclude = {"seats", "cruises"})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ship {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "ship", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @Builder.Default
    private List<Seat> seats = new ArrayList<>();

    @OneToMany(mappedBy = "ship")
    @Builder.Default
    private List<Cruise> cruises = new ArrayList<>();

    public void addSeat(Seat seat){
        this.seats.add(seat);
    }

    public void addCruise(Cruise cruise){
        cruises.add(cruise);
    }
}
