package com.didenko.starcruises.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(exclude = "cruise")
@ToString(exclude = "cruise")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Port {

    @Id
    private Long id;

    private String name;

    private LocalDate visitDate;

    @ManyToOne
    private Cruise cruise;

}
