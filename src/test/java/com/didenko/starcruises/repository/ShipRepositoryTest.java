package com.didenko.starcruises.repository;

import com.didenko.starcruises.entity.*;
import com.didenko.starcruises.integration.BaseIntegrationTest;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

public class ShipRepositoryTest extends BaseIntegrationTest {

    private static final Long SHIP_1_ID = 101L;
    private static final String SHIP_1_NAME = "Sidonia";
    private static final Integer SHIP_1_CRUISES_NUMBER = 3;
    private static final Integer SHIP_1_SEATS_NUMBER = 15;

    private static final Long SHIP_2_ID = 102L;
    private static final String SHIP_2_NAME = "Andromeda";

    private static final Integer TOTAL_SHIPS_QUANTITY = 10;

    private static final Ship SHIP_TO_SAVE = Ship.builder()
            .name("saved ship")
            .build();

    @Autowired
    private ShipRepository shipRepository;
    @Autowired
    private EntityManager entityManager;

    @DisplayName("find ship by id test")
    @Test
    void findById(){
        Optional<Ship> maybeShip = shipRepository.findById(SHIP_1_ID);

        assertTrue(maybeShip.isPresent());
        assertEquals(SHIP_1_NAME, maybeShip.get().getName());
        assertEquals(SHIP_1_ID, maybeShip.get().getId());
        assertEquals(SHIP_1_CRUISES_NUMBER, maybeShip.get().getCruises().size());
        assertEquals(SHIP_1_SEATS_NUMBER, maybeShip.get().getSeats().size());
    }

    @DisplayName("find ship by name test")
    @Test
    void findByShipName(){
        Optional<Ship> maybeShip = shipRepository.findByName(SHIP_2_NAME);

        assertTrue(maybeShip.isPresent());
        assertEquals(SHIP_2_ID, maybeShip.get().getId());
        assertEquals(SHIP_2_NAME, maybeShip.get().getName());
    }

    @DisplayName("find all ships test")
    @Test
    void findAllShips(){
        List<Ship> allShips = shipRepository.findAll();

        assertEquals(TOTAL_SHIPS_QUANTITY, allShips.size());
    }

    @DisplayName("save new ship test")
    @Test
    void saveShip(){
        entityManager.persist(SHIP_TO_SAVE);

        assertNotNull(SHIP_TO_SAVE.getId());
    }
}