package com.didenko.starcruises.integration.service;

import com.didenko.starcruises.dto.CruiseCreateEditDto;
import com.didenko.starcruises.dto.CruiseReadDto;
import com.didenko.starcruises.dto.PortCreateEditDto;
import com.didenko.starcruises.entity.CruiseFilter;
import com.didenko.starcruises.entity.CruiseSearchDurationOptions;
import com.didenko.starcruises.entity.CruiseSortOptions;
import com.didenko.starcruises.integration.BaseIntegrationTest;
import com.didenko.starcruises.repository.PortRepository;
import com.didenko.starcruises.service.CruiseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CruiseServiceIT extends BaseIntegrationTest {

    private static final Long FIND_READ_DTO_BY_ID_ID = 106L;
    private static final CruiseReadDto FIND_READ_DTO_BY_ID_RESULT = CruiseReadDto.builder()
            .id(106L)
            .description("Adventure cruise with wildlife sightings")
            .duration(48)
            .shipName("Good Boi")
            .firstPort("Marina Vista")
            .lastPort("Harbor Master's Dock")
            .firstPortDate(LocalDate.of(2025, 1, 6))
            .lastPortDate(LocalDate.of(2025, 2, 23))
            .intermediatePorts("Captain's Cove Port, " +
                    "Coastal Haven Port, " +
                    "Marina Del Sol, " +
                    "Port of Tranquility, " +
                    "Surfside Marina, " +
                    "Coastal Haven Port, " +
                    "Harbor Master's Dock")
            .startingPrice("1000.00")
            .build();

    private static final Integer TOTAL_CRUISE_NUMBER = 15;

    private static final Long FIND_ENTITY_BY_ID_ID = 102L;

    private static final Long FIND_EDIT_DTO_BY_ID_ID = 105L;
    private static final CruiseCreateEditDto FIND_EDIT_DTO_BY_ID_RESULT = CruiseCreateEditDto.builder()
            .id(105L)
            .ship("Good Boi")
            .description("Historical cruise with cultural excursions")
            .build();
    private static final Integer FIND_EDIT_DTO_BY_ID_PORTS_NUMBER = 3;
    private static final PortCreateEditDto FIND_EDIT_DTO_BY_ID_PORT = PortCreateEditDto.builder()
            .id(1041L)
            .name("Beachcomber's Harbor")
            .visitDate(LocalDate.of(2025, 1, 13).toString())
            .build();

    private static final CruiseFilter FILTER_BY_SHIP_NAME =
            new CruiseFilter("Sidonia", null, null, null, null);
    private static final Integer FILTER_BY_SHIP_NAME_RESULT = 3;

    private static final CruiseFilter FILTER_BY_FIRST_PORT =
            new CruiseFilter(null, "Captain's Cove Port", null, null, null);
    private static final Integer FILTER_BY_FIRST_PORT_REUSLT = 2;

    private static final CruiseFilter FILTER_BY_DEPARTURE_DATE =
            new CruiseFilter(null, null, LocalDate.of(2025, 1, 30), null, null);
    private static final Integer FILTER_BY_DEPARTURE_DATE_RESULT = 3;

    private static final CruiseFilter FILTER_BY_DURATION =
            new CruiseFilter(null, null, null,
                    CruiseSearchDurationOptions.SHORT, null);
    private static final Integer FILTER_BY_DURATION_RESULT = 1;

    private static final CruiseFilter FILTER_BY_NON_EXISTING_SHIP =
            new CruiseFilter("no such ship", null, null,
                    null, null);

    private static final CruiseFilter FILTER_BY_SHIP_NAME_AND_FIRST_PORT =
            new CruiseFilter("Sidonia", null, LocalDate.of(2025, 1, 5),
                    null, null);
    private static final Integer FILTER_BY_SHIP_NAME_AND_FIRST_PORT_RESULT = 2;

    private static final PortCreateEditDto PORT_TO_SAVE_1 = PortCreateEditDto.builder()
            .name("Amsterdam")
            .visitDate("2025-03-15")
            .build();
    private static final PortCreateEditDto PORT_TO_SAVE_2 = PortCreateEditDto.builder()
            .name("Antwerp")
            .visitDate("2025-03-17")
            .build();
    private static final PortCreateEditDto PORT_TO_SAVE_3 = PortCreateEditDto.builder()
            .name("Brest")
            .visitDate("2025-03-23")
            .build();
    private static final CruiseCreateEditDto CRUISE_TO_SAVE_DTO = CruiseCreateEditDto.builder()
            .description("cruise description")
            .ship("Sidonia")
            .ports(List.of(PORT_TO_SAVE_1, PORT_TO_SAVE_2, PORT_TO_SAVE_3))
            .build();

    private static final PortCreateEditDto PORT_TO_UPDATE_1 = PortCreateEditDto.builder()
            .id(1052L)
            .name("Seagull Cove Port")
            .visitDate("2025-02-02")
            .build();
    private static final PortCreateEditDto PORT_TO_UPDATE_2 = PortCreateEditDto.builder()
            .id(1010L)
            .name("Seascape Marina")
            .visitDate("2025-02-15")
            .build();
    private static final PortCreateEditDto PORT_TO_UPDATE_3 = PortCreateEditDto.builder()
            .id(1061L)
            .name("Palm Tree Marina")
            .visitDate("2025-02-28")
            .build();
    private static final PortCreateEditDto PORT_TO_UPDATE_4 = PortCreateEditDto.builder()
            .name("Added Port")
            .visitDate("2025-03-01")
            .build();

    private static final CruiseCreateEditDto CRUISE_TO_UPDATE = CruiseCreateEditDto.builder()
            .id(104L)
            .ship("Andromeda")
            .description("new description")
            .ports(List.of(PORT_TO_UPDATE_1, PORT_TO_UPDATE_2, PORT_TO_UPDATE_3, PORT_TO_UPDATE_4))
            .build();

    @Autowired
    private CruiseService cruiseService;
    @Autowired
    private PortRepository portRepository;

    @Test
    void updateCruiseAdd(){
        var updatedId = cruiseService.save(CRUISE_TO_UPDATE);
        assertEquals(104L, updatedId);

        var maybeUpdatedCruise = cruiseService.findCruiseEntityById(updatedId);
        assertTrue(maybeUpdatedCruise.isPresent());

        var updatedCruise = maybeUpdatedCruise.get();
        assertEquals("new description", updatedCruise.getDescription());
        assertEquals(4, updatedCruise.getPorts().size());
        assertEquals(27, updatedCruise.getDuration());

        assertEquals(1052L, updatedCruise.getFirstPort().getId());
        assertEquals("Seagull Cove Port", updatedCruise.getFirstPort().getName());
        assertEquals(LocalDate.of(2025, 2, 2), updatedCruise.getFirstPort().getVisitDate());

        assertEquals("Added Port", updatedCruise.getLastPort().getName());
        assertEquals(LocalDate.of(2025, 3, 1), updatedCruise.getLastPort().getVisitDate());

        assertFalse(portRepository.existsById(1060L));
    }

    @Test
    void saveNewCruise(){
        var savedId = cruiseService.save(CRUISE_TO_SAVE_DTO);

        assertNotNull(savedId);

        var maybeSavedCruise = cruiseService.findCruiseEntityById(savedId);
        assertTrue(maybeSavedCruise.isPresent());

        var savedCruise = maybeSavedCruise.get();
        assertEquals("Sidonia", savedCruise.getShip().getName());
        assertEquals("cruise description", savedCruise.getDescription());
        assertEquals(8, savedCruise.getDuration());
        assertEquals("Amsterdam", savedCruise.getFirstPort().getName());
        assertEquals("Brest", savedCruise.getLastPort().getName());
        assertEquals(3, savedCruise.getPorts().size());
        assertEquals(LocalDate.of(2025, 3, 17), savedCruise.getPorts().get(1).getVisitDate());
    }

    @Test
    void findByFilterAndSorting() {
        var cruises = cruiseService.findCruisesByFilter(new CruiseFilter(
                null, null, null, null, CruiseSortOptions.DURATION_ASCENDING
        ));

        assertFalse(cruises.isEmpty());
        assertEquals(6, cruises.get(0).getDuration());
        assertEquals(11, cruises.get(1).getDuration());
        assertEquals(25, cruises.get(3).getDuration());
        assertEquals(47, cruises.get(10).getDuration());
        assertEquals(49, cruises.get(14).getDuration());
    }

    @Test
    void findByFilterShipNameAndFirstPort() {
        var cruises = cruiseService.findCruisesByFilter(FILTER_BY_SHIP_NAME_AND_FIRST_PORT);

        assertEquals(FILTER_BY_SHIP_NAME_AND_FIRST_PORT_RESULT, cruises.size());
    }

    @Test
    void findByFilterNonExistingShip() {
        var cruises = cruiseService.findCruisesByFilter(FILTER_BY_NON_EXISTING_SHIP);

        assertTrue(cruises.isEmpty());
    }

    @Test
    void findByFilterDuration() {
        var cruises = cruiseService.findCruisesByFilter(FILTER_BY_DURATION);

        assertEquals(FILTER_BY_DURATION_RESULT, cruises.size());
    }

    @Test
    void findByFilterDepartureDate() {
        var cruises = cruiseService.findCruisesByFilter(FILTER_BY_DEPARTURE_DATE);

        assertEquals(FILTER_BY_DEPARTURE_DATE_RESULT, cruises.size());
    }

    @Test
    void findByFilterShipNameCase() {
        var cruises = cruiseService.findCruisesByFilter(FILTER_BY_SHIP_NAME);

        assertFalse(cruises.isEmpty());
        assertEquals(FILTER_BY_SHIP_NAME_RESULT, cruises.size());
    }

    @Test
    void findByFilterFirstPortNameCase() {
        var cruises = cruiseService.findCruisesByFilter(FILTER_BY_FIRST_PORT);

        assertFalse(cruises.isEmpty());
        assertEquals(FILTER_BY_FIRST_PORT_REUSLT, cruises.size());
    }

    @Test
    void findEditDtoById() {
        var maybeCruise = cruiseService.findEditDtoById(FIND_EDIT_DTO_BY_ID_ID);

        assertTrue(maybeCruise.isPresent());
        assertEquals(FIND_EDIT_DTO_BY_ID_RESULT, maybeCruise.get());
        assertTrue(maybeCruise.get().getPorts().contains(FIND_EDIT_DTO_BY_ID_PORT));
        assertEquals(FIND_EDIT_DTO_BY_ID_PORTS_NUMBER, maybeCruise.get().getPorts().size());
    }

    @Test
    void findAllCruises() {
        var cruiseReadDtos = cruiseService.findAllCruises();

        assertEquals(TOTAL_CRUISE_NUMBER, cruiseReadDtos.size());
    }

    @Test
    void findReadDtoById() {
        var maybeCruiseDto = cruiseService.findReadDtoById(FIND_READ_DTO_BY_ID_ID);

        assertTrue(maybeCruiseDto.isPresent());
        assertEquals(FIND_READ_DTO_BY_ID_RESULT, maybeCruiseDto.get());
    }

    @Test
    void findCruiseEntityById() {
        var maybeCruise = cruiseService.findCruiseEntityById(FIND_ENTITY_BY_ID_ID);

        assertTrue(maybeCruise.isPresent());
        assertEquals(FIND_ENTITY_BY_ID_ID, maybeCruise.get().getId());
    }

}
