package com.didenko.starcruises.dto;

import com.didenko.starcruises.entity.SeatClass;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SeatReadDto {

    private SeatClass seatClass;

    private Long freeSeatsAvailable;

    private BigDecimal price;

    private Integer numberOfPersons;

    private Integer seatGroup;
}