package com.didenko.starcruises.integration.repository;

import com.didenko.starcruises.integration.BaseIntegrationTest;
import com.didenko.starcruises.repository.CruiseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CruiseRepositoryTest extends BaseIntegrationTest {

    private static final Long CRUISE_ID_1 = 101L;
    private static final String CRUISE_1_DESCRIPTION = "Historical cruise with cultural excursions";
    private static final Long CRUISE_1_SHIP_ID = 105L;

    private static final Integer TOTAL_CRUISE_NUMBER = 15;

    @Autowired
    private CruiseRepository cruiseRepository;

    @Test
    void findAll() {
        assertEquals(TOTAL_CRUISE_NUMBER, cruiseRepository.findAll().size());
    }

    @Test
    void findById(){
        var maybeCruise = cruiseRepository.findById(CRUISE_ID_1);

        assertTrue(maybeCruise.isPresent());
        assertEquals(CRUISE_ID_1, maybeCruise.get().getId());
        assertEquals(CRUISE_1_SHIP_ID, maybeCruise.get().getShip().getId());
        assertEquals(CRUISE_1_DESCRIPTION, maybeCruise.get().getDescription());
    }
}