package com.didenko.starcruises.service;

import com.didenko.starcruises.dto.SeatCreateEditDto;
import com.didenko.starcruises.dto.ShipCreateEditDto;
import com.didenko.starcruises.entity.SeatClass;
import com.didenko.starcruises.integration.BaseIntegrationTest;
import com.didenko.starcruises.mapper.SeatCreateEditDtoMapper;
import com.didenko.starcruises.mapper.ShipCreateEditDtoMapper;
import com.didenko.starcruises.repository.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipServiceTest extends BaseIntegrationTest {

    private static final Long SHIP_ID = 104L;

    private static final Integer TOTAL_SHIPS = 10;

    private static final SeatCreateEditDto SEAT_TO_SAVE_1 = SeatCreateEditDto.builder()
            .seatGroup(1)
            .seatClass(SeatClass.OUTSIDE_VIEW)
            .seatPrice("5000")
            .firstSeatNumber(1)
            .lastSeatNumber(8)
            .numberOfPersons(3)
            .build();
    private static final SeatCreateEditDto SEAT_TO_SAVE_2 = SeatCreateEditDto.builder()
            .seatGroup(2)
            .seatClass(SeatClass.BALCONY)
            .seatPrice("4000")
            .firstSeatNumber(9)
            .lastSeatNumber(15)
            .numberOfPersons(2)
            .build();
    private static final ShipCreateEditDto SHIP_TO_SAVE = ShipCreateEditDto.builder()
            .name("Calisto")
            .seats(List.of(SEAT_TO_SAVE_1, SEAT_TO_SAVE_2))
            .build();

    private static final ShipCreateEditDto SHIP_TO_UPDATE = ShipCreateEditDto.builder()
            .id(103L)
            .name("Navius2")
            .previousName("Navius")
            .build();

    @Autowired
    private ShipService shipService;
    @Autowired
    private ShipRepository shipRepository;
    @Autowired
    private ShipCreateEditDtoMapper shipCreateEditDtoMapper;

    @Test
    void findById() {
        var maybeShipDto = shipService.findById(SHIP_ID);

        assertTrue(maybeShipDto.isPresent());
        var shipDto = maybeShipDto.get();
        assertEquals(SHIP_ID, shipDto.getId());
        assertEquals("Sirius", shipDto.getName());
        assertEquals("Sirius", shipDto.getPreviousName());
        assertEquals(3, shipDto.getSeats().size());
    }

    @Test
    void save() {
        var savedShipDto = shipService.save(SHIP_TO_SAVE);

        assertNotNull(savedShipDto.getId());

        var maybeSavedShip = shipRepository.findById(savedShipDto.getId());
        assertTrue(maybeSavedShip.isPresent());

        var savedShip = maybeSavedShip.get();
        assertEquals(savedShip.getId(), savedShipDto.getId());
        assertEquals("Calisto", savedShip.getName());
        assertEquals(15, savedShip.getSeats().size());
        assertTrue(savedShip.getCruises().isEmpty());
    }

    @Test
    void update(){
        var updatedShipDto = shipService.save(SHIP_TO_UPDATE);

        var maybeUpdatedShip = shipRepository.findById(updatedShipDto.getId());
        assertTrue(maybeUpdatedShip.isPresent());

        var updatedShip = maybeUpdatedShip.get();
        assertEquals(updatedShipDto.getId(), updatedShip.getId());
        assertEquals("Navius2", updatedShipDto.getName());
        assertEquals(15, updatedShip.getSeats().size());
        assertEquals(1, updatedShip.getCruises().size());
    }

    @Test
    void findAll() {
        var ships = shipService.findAll();

        assertEquals(TOTAL_SHIPS, ships.size());
    }
}