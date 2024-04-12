package com.didenko.starcruises.integration.service;

import com.didenko.starcruises.dto.SeatReadDto;
import com.didenko.starcruises.entity.SeatClass;
import com.didenko.starcruises.integration.BaseIntegrationTest;
import com.didenko.starcruises.service.SeatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeatServiceTest extends BaseIntegrationTest {

    private static final Long CRUISE_ID = 102L;
    private static final SeatReadDto SEAT_READ_DTO = SeatReadDto.builder()
            .seatGroup(2)
            .seatClass(SeatClass.OUTSIDE_VIEW)
            .numberOfPersons(3)
            .price(new BigDecimal("1000.00"))
            .freeSeatsAvailable(5L)
            .build();

    private static final Long SHIP_ID = 103L;
    private static final Integer SEAT_GROUP = 3;

    @Autowired
    private SeatService seatService;

    @Test
    void findSeatsByCruiseId() {
        var seats = seatService.findSeatsByCruiseId(CRUISE_ID);

        assertTrue(seats.contains(SEAT_READ_DTO));
    }

    @Test
    void findVacantSeatByShipIdAndSeatGroup() {
        var maybeSeat = seatService.findVacantSeatByShipIdAndSeatGroup(SHIP_ID, SEAT_GROUP);

        assertTrue(maybeSeat.isPresent());

        var seat = maybeSeat.get();
        assertTrue(List.of(1041L, 1042L, 1043L).contains(seat.getId()));
        assertEquals(103L, seat.getShip().getId());
        assertEquals(3, seat.getSeatGroup());
        assertEquals(3, seat.getNumberOfPersons());
    }
}