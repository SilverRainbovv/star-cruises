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

    @Id
    private Long id;

    private String number;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Vacancy vacancy;

    @ManyToOne
    private Ship ship;

}
