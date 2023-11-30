package com.didenko.starcruises.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @Id
    private Long id;

    private String name;

    @OneToMany
    @Builder.Default
    private List<Seat> seats = new ArrayList<>();

    @OneToMany
    @Builder.Default
    private List<Cruise> cruises = new ArrayList<>();
}
