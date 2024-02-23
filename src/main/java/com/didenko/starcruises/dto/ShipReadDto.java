package com.didenko.starcruises.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShipReadDto {

    private Long id;

    private String name;

    private Integer scheduledCruises;

    private Integer passengerCapacity;

    private String image;
}
