package com.didenko.starcruises.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@EqualsAndHashCode(of = "name")
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

    @OneToMany(mappedBy = "ship", fetch = FetchType.LAZY, cascade = {PERSIST, MERGE, REFRESH})
    @Builder.Default
    private List<Seat> seats = new ArrayList<>();

    @OneToMany(mappedBy = "ship")
    @Builder.Default
    private List<Cruise> cruises = new ArrayList<>();

    private String image;

    public void addSeat(Seat seat){
        this.seats.add(seat);
    }

    public void removeSeats(List<Seat> seats){
        this.seats.removeAll(seats);
    }

    public void addCruise(Cruise cruise){
        cruises.add(cruise);
    }
}
