package com.didenko.starcruises.unit.mapper;

import com.didenko.starcruises.dto.ShipReadDto;
import com.didenko.starcruises.entity.*;
import com.didenko.starcruises.mapper.ShipReadDtoMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipReadDtoMapperTest {

    private final ShipReadDtoMapper mapper = new ShipReadDtoMapper();

    private static final Cruise CRUISE_1 = Cruise.builder()
            .build();
    private static final Cruise CRUISE_2 = Cruise.builder()
            .build();
    private static final Seat SEAT_1 = Seat.builder()
            .numberOfPersons(2)
            .build();
    private static final Seat SEAT_2 = Seat.builder()
            .numberOfPersons(3)
            .build();
    private static final Ship SHIP = Ship.builder()
            .id(1L)
            .name("ship")
            .image("image_url")
            .seats(List.of(SEAT_1, SEAT_2))
            .cruises(List.of(CRUISE_1, CRUISE_2))
            .build();

    private static final ShipReadDto SHIP_DTO_MAPPED = ShipReadDto.builder()
            .id(1L)
            .name("ship")
            .scheduledCruises(2)
            .passengerCapacity(5)
            .image("image_url")
            .build();

    @Test
    void mapFrom() {
        var result = mapper.mapFrom(SHIP);
        assertEquals(SHIP_DTO_MAPPED, result);
    }
}