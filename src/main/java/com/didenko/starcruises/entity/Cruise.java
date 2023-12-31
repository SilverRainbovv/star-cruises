package com.didenko.starcruises.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    private Ship ship;

    @OneToMany
    @Builder.Default
    private List<Port> ports = new ArrayList<>();

}
