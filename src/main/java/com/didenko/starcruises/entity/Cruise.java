package com.didenko.starcruises.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;



@EqualsAndHashCode(exclude = {"ship", "ports"})
@ToString(exclude = {"ship", "ports"})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cruise {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String description;

    @ManyToOne
    private Ship ship;

    @OneToMany(mappedBy = "cruise",  fetch = FetchType.LAZY, cascade = {PERSIST, MERGE, REFRESH})
    @Builder.Default
    private List<Port> ports = new ArrayList<>();

    private String image;

    @OneToOne
    private Port firstPort;

    @OneToOne
    private Port lastPort;

    private Integer duration;

    public void setShip(Ship ship) {
        this.ship = ship;
        ship.addCruise(this);
    }

    public void addPort(Port port){
        ports.add(port);
    }

    public void removePorts(List<Port> toBeRemoved) {
        ports.removeAll(toBeRemoved);
    }
}
