package com.didenko.starcruises.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ShipReadDto implements Serializable {

    private Long id;

    private String name;

    private Integer scheduledCruises;

    private Integer passengerCapacity;

    private String image;

}
