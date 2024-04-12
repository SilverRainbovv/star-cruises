package com.didenko.starcruises.querydsl;

import com.didenko.starcruises.entity.CruiseSearchDurationOptions;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CruiseFilter (String shipName, String departurePort, CruiseSearchDurationOptions duration, LocalDate departureDate){
}
