package com.didenko.starcruises.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CruiseReadDto {

    private Long id;

    private String description;

    private Integer duration;

    private String shipName;

    private String firstPort;

    private String lastPort;

    private LocalDate firstPortDate;

    private LocalDate lastPortDate;

    private String intermediatePorts;

    private String startingPrice;

    private String image;

    private String state;
}
