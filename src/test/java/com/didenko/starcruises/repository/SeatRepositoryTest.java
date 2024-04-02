package com.didenko.starcruises.repository;

import com.didenko.starcruises.entity.Cruise;
import com.didenko.starcruises.integration.BaseIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class SeatRepositoryTest extends BaseIntegrationTest {

    private static final Long CRUISE_ID = 101L;
    private static final Long SHIP_ID = 105L;
    private static final Integer SEATS_NUMBER = 15;

    private static final Long SHIP_ID_SEARCH_BY_SHIP_ID_AND_SEAT_GROUP = 101L;
    private static final Long SEAT_ID_SEARCH_BY_SHIP_ID_AND_SEAT_GROUP = 1006L;
    private static final Integer SEAT_GROUP_SEARCH_BY_SHIP_ID_AND_SEAT_GROUP = 2;
    private static final Integer SEAT_NUMBER_SEARCH_BY_SHIP_ID_AND_SEAT_GROUP = 6;


    @Autowired
    private SeatRepository seatRepository;

    @Test
    void findAllByCruiseId() {
        var seats = seatRepository.findAllByCruiseId(CRUISE_ID);

        assertTrue(seats.stream().allMatch(seat -> seat.getShip().getId().equals(SHIP_ID)));
        assertEquals(SEATS_NUMBER, seats.size());
        assertTrue(seats.get(0).getShip().getCruises().stream().map(Cruise::getId).anyMatch(id -> id.equals(CRUISE_ID)));
    }

    @Test
    void findFirstByShipIdAndSeatGroup() {
        var maybeSeat = seatRepository.findFirstByShipIdAndSeatGroup(SHIP_ID_SEARCH_BY_SHIP_ID_AND_SEAT_GROUP,
                SEAT_GROUP_SEARCH_BY_SHIP_ID_AND_SEAT_GROUP);

        assertTrue(maybeSeat.isPresent());
        assertEquals(SEAT_ID_SEARCH_BY_SHIP_ID_AND_SEAT_GROUP, maybeSeat.get().getId());
        assertEquals(SHIP_ID_SEARCH_BY_SHIP_ID_AND_SEAT_GROUP, maybeSeat.get().getShip().getId());
        assertEquals(SEAT_GROUP_SEARCH_BY_SHIP_ID_AND_SEAT_GROUP, maybeSeat.get().getSeatGroup());
        assertEquals(SEAT_NUMBER_SEARCH_BY_SHIP_ID_AND_SEAT_GROUP, maybeSeat.get().getNumber());
    }
}