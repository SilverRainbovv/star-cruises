package com.didenko.starcruises.unit.mapper;

import com.didenko.starcruises.dto.CruiseCreateEditDto;
import com.didenko.starcruises.dto.PortCreateEditDto;
import com.didenko.starcruises.entity.Cruise;
import com.didenko.starcruises.entity.Port;
import com.didenko.starcruises.entity.Ship;
import com.didenko.starcruises.mapper.CruiseCreateEditDtoMapper;
import com.didenko.starcruises.mapper.PortCreateEditDtoMapper;
import com.didenko.starcruises.repository.ShipRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CruiseCreateEditDtoMapperTest {

    private static final Ship SHIP = Ship.builder()
            .name("ship")
            .build();
    private static final Port PORT_1 = Port.builder()
            .visitDate(LocalDate.of(2026,12,1))
            .name("Venice")
            .build();
    private static final Port PORT_2 = Port.builder()
            .name("Brest")
            .visitDate(LocalDate.of(2026,12,15))
            .build();
    private static final Cruise MAPPED_CRUISE = Cruise.builder()
            .ports(List.of(PORT_1, PORT_2))
            .ship(SHIP)
            .description("great cruise")
            .firstPort(PORT_1)
            .lastPort(PORT_2)
            .duration(14)
            .build();
    private static final PortCreateEditDto PORT_CREATE_EDIT_DTO_1 = PortCreateEditDto.builder()
            .name("Venice")
            .visitDate(LocalDate.of(2026,12,1).toString())
            .build();
    private static final PortCreateEditDto PORT_CREATE_EDIT_DTO_2 = PortCreateEditDto.builder()
            .name("Brest")
            .visitDate(LocalDate.of(2026,12,15).toString())
            .build();
    private static final CruiseCreateEditDto CRUISE_CREATE_EDIT_DTO = CruiseCreateEditDto.builder()
            .id(1L)
            .ship("ship")
            .description("great cruise")
            .ports(List.of(PORT_CREATE_EDIT_DTO_1, PORT_CREATE_EDIT_DTO_2))
            .build();
    private static final CruiseCreateEditDto MAPPED_CRUISE_CREATE_EDIT_DTO = CruiseCreateEditDto.builder()
            .ship("ship")
            .description("great cruise")
            .ports(List.of(PORT_CREATE_EDIT_DTO_1, PORT_CREATE_EDIT_DTO_2))
            .build();

    @Mock
    private ShipRepository shipRepository;
    @Mock
    private PortCreateEditDtoMapper portCreateEditDtoMapper;
    @InjectMocks
    private CruiseCreateEditDtoMapper mapper;

    @Test
    void testMapFromDto() {
        Mockito.doReturn(PORT_1).when(portCreateEditDtoMapper).mapFrom(PORT_CREATE_EDIT_DTO_1);
        Mockito.doReturn(PORT_2).when(portCreateEditDtoMapper).mapFrom(PORT_CREATE_EDIT_DTO_2);
        Mockito.doReturn(Optional.of(SHIP)).when(shipRepository).findByName(Mockito.any());

        assertEquals(MAPPED_CRUISE, mapper.mapFrom(CRUISE_CREATE_EDIT_DTO));
    }

    @Test
    void testMapFromEntity() {
        Mockito.doReturn(PORT_CREATE_EDIT_DTO_1).when(portCreateEditDtoMapper).mapFrom(PORT_1);
        Mockito.doReturn(PORT_CREATE_EDIT_DTO_2).when(portCreateEditDtoMapper).mapFrom(PORT_2);

        assertEquals(MAPPED_CRUISE_CREATE_EDIT_DTO, mapper.mapFrom(MAPPED_CRUISE));
    }
}