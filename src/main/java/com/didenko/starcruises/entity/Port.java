package com.didenko.starcruises.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(of = {"name", "visitDate"})
@ToString(exclude = "cruise")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Port {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private LocalDate visitDate;

    @ManyToOne
    private Cruise cruise;

    public void setCruise(Cruise cruise) {
        this.cruise = cruise;
        cruise.addPort(this);
    }
}
