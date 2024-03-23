package com.didenko.starcruises.querydsl;

import com.didenko.starcruises.entity.CruiseSearchDurationOptions;

import java.time.LocalDate;

public record CruiseFilter (String shipName, String departurePort, CruiseSearchDurationOptions duration, LocalDate departureDate){
}
