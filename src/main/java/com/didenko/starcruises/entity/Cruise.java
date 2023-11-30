package com.didenko.starcruises.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @Id
    private Long id;

    @ManyToOne
    private Ship ship;

    @OneToMany
    @Builder.Default
    private List<Port> ports = new ArrayList<>();

}
