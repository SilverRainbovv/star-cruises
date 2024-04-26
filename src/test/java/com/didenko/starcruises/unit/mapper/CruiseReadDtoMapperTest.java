package com.didenko.starcruises.unit.mapper;

import com.didenko.starcruises.dto.CruiseReadDto;
import com.didenko.starcruises.entity.Cruise;
import com.didenko.starcruises.entity.Port;
import com.didenko.starcruises.entity.Seat;
import com.didenko.starcruises.entity.Ship;
import com.didenko.starcruises.mapper.CruiseReadDtoMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CruiseReadDtoMapperTest {

    private static final Seat SEAT_1 = Seat.builder()
            .price(new BigDecimal(10))
            .build();
    private static final Seat SEAT_2 = Seat.builder()
            .price(new BigDecimal(5))
            .build();
    private static final Seat SEAT_3 = Seat.builder()
            .price(new BigDecimal(15))
            .build();
    private static final Ship SHIP = Ship.builder()
            .seats(List.of(SEAT_1, SEAT_2, SEAT_3))
            .name("ship")
            .build();
    private static final Port PORT_1 = Port.builder()
            .visitDate(LocalDate.of(2026,12,1))
            .name("Venice")
            .build();
    private static final Port PORT_2 = Port.builder()
            .name("Naples")
            .visitDate(LocalDate.of(2026,12,3))
            .build();
    private static final Port PORT_3 = Port.builder()
            .name("Florence")
            .visitDate(LocalDate.of(2026,12,7))
            .build();
    private static final Port PORT_4 = Port.builder()
            .name("Brest")
            .visitDate(LocalDate.of(2026,12,15))
            .build();
    private static final Cruise CRUISE = Cruise.builder()
            .id(1L)
            .ship(SHIP)
            .description("great cruise")
            .firstPort(PORT_1)
            .lastPort(PORT_4)
            .duration(14)
            .build();
    private static final CruiseReadDto CRUISE_READ_DTO = CruiseReadDto.builder()
            .id(1L)
            .description("great cruise")
            .duration(14)
            .shipName("ship")
            .firstPort("Venice")
            .lastPort("Brest")
            .firstPortDate(LocalDate.of(2026,12,1))
            .lastPortDate(LocalDate.of(2026,12,15))
            .intermediatePorts(String.join(", ", "Naples", "Florence", "Brest"))
            .startingPrice("5")
            .image(null)
            .build();

    private final CruiseReadDtoMapper mapper = new CruiseReadDtoMapper();

    @BeforeAll
    static void prepareEntity(){
        PORT_1.setCruise(CRUISE);
        PORT_2.setCruise(CRUISE);
        PORT_3.setCruise(CRUISE);
        PORT_4.setCruise(CRUISE);
    }

    @Test
    void mapFrom() {

        assertEquals(CRUISE_READ_DTO, mapper.mapFrom(CRUISE));

    }
}