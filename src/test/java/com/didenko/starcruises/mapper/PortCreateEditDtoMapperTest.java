package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.PortCreateEditDto;
import com.didenko.starcruises.entity.Port;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.parameters.P;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PortCreateEditDtoMapperTest {

    private static final Port PORT = Port.builder()
            .id(1L)
            .visitDate(LocalDate.of(2026,12,1))
            .name("Venice")
            .build();

    private static final PortCreateEditDto MAPPED_PORT_DTO = PortCreateEditDto.builder()
            .visitDate(LocalDate.of(2026,12,1).toString())
            .name("Venice")
            .build();
    private static final PortCreateEditDto PORT_DTO = PortCreateEditDto.builder()
            .visitDate(LocalDate.of(2026,12,1).toString())
            .name("Venice")
            .build();
    private static final Port MAPPED_PORT_ENTITY = Port.builder()
            .visitDate(LocalDate.of(2026,12,1))
            .name("Venice")
            .build();

    private final PortCreateEditDtoMapper mapper = new PortCreateEditDtoMapper();
    @Test
    void mapFromDto() {
        assertEquals(MAPPED_PORT_ENTITY, mapper.mapFrom(PORT_DTO));
    }

    @Test
    void mapFromEntity() {
        assertEquals(MAPPED_PORT_DTO, mapper.mapFrom(PORT));
    }
}