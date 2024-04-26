package com.didenko.starcruises.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.function.Predicate;

@NoArgsConstructor
@Data
public class CruiseFilter {

    public Predicate<String> departurePortPredicate = port ->
            (this.departurePort == null || getDeparturePort().isEmpty()) || port.equals(getDeparturePort());

    public CruiseFilter(String shipName,
                        String departurePort,
                        LocalDate departureAfter,
                        CruiseSearchDurationOptions nights,
                        CruiseSortOptions sortOption,
                        PageSizeOption pageSize,
                        Integer pageNumber){
        this.departurePort = departurePort == null ? "": departurePort;
        this.departureAfter = departureAfter == null ? LocalDate.now() : departureAfter;
        this.nights = nights == null ? CruiseSearchDurationOptions.ANY : nights;
        this.shipName = shipName == null ? "" : shipName;
        this.sortOption = sortOption == null ? CruiseSortOptions.DEPARTURE_EARLIEST : sortOption;
        this.pageSize = pageSize == null ? PageSizeOption.FIVE : pageSize;
        this.pageNumber = pageNumber == null ? 0 : pageNumber;
    }
    private String shipName;

    private String departurePort;

    private LocalDate departureAfter;

    private CruiseSearchDurationOptions nights;

    private CruiseSortOptions sortOption;

    private PageSizeOption pageSize;

    private Integer pageNumber;
}
