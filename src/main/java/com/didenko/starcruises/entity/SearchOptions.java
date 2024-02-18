package com.didenko.starcruises.entity;

import lombok.Data;

import java.time.LocalDate;


@Data
public class SearchOptions {

    public SearchOptions(String shipName,
                         String departurePort,
                         LocalDate departureAfter,
                         CruiseSearchDurationOptions nights,
                         CruiseSortOptions sortOption){
        this.departurePort = departurePort == null ? "": departurePort;
        this.departureAfter = departureAfter == null ? LocalDate.now() : departureAfter;
        this.nights = nights;
        this.shipName = shipName;
        this.sortOption = sortOption;
    }

    private String shipName;

    private String departurePort;

    private LocalDate departureAfter;

    private CruiseSearchDurationOptions nights;

    private CruiseSortOptions sortOption;

}
