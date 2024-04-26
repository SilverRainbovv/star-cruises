package com.didenko.starcruises.unit.mapper;

import com.didenko.starcruises.dto.TicketReadDto;
import com.didenko.starcruises.entity.*;
import com.didenko.starcruises.mapper.TicketReadDtoMapper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TicketReadDtoMapperTest {

    private final TicketReadDtoMapper mapper = new TicketReadDtoMapper();

    private static final Ship SHIP = Ship.builder()
            .name("ship")
            .build();
    private static final Cruise CRUISE = Cruise.builder()
            .id(1L)
            .ship(SHIP)
            .description("great cruise")
            .duration(14)
            .build();
    private static final Seat SEAT = Seat.builder()
            .seatGroup(1)
            .number(1)
            .numberOfPersons(3)
            .price(new BigDecimal(500))
            .vacancy(SeatVacancy.VACANT)
            .seatClass(SeatClass.SUITE)
            .build();
    private static final Ticket TICKET_NOT_CANCELED = Ticket.builder()
            .id(1L)
            .cruise(CRUISE)
            .seat(SEAT)
            .state(TicketState.PENDING)
            .build();
    private static final Ticket TICKET_CANCELED = Ticket.builder()
            .id(1L)
            .cruise(CRUISE)
            .seat(SEAT)
            .state(TicketState.CANCELLED)
            .build();

    private static final TicketReadDto TICKET_READ_DTO_MAPPED_NOT_CANCELED = TicketReadDto.builder()
            .ticketId(1L)
            .ship("ship")
            .cruise("great cruise")
            .price(new BigDecimal(500))
            .seatClass(SeatClass.SUITE)
            .numberOfPersons(3)
            .ticketState(TicketState.PENDING)
            .isCanceled(false)
            .build();
    private static final TicketReadDto TICKET_READ_DTO_MAPPED_CANCELED = TicketReadDto.builder()
            .ticketId(1L)
            .ship("ship")
            .cruise("great cruise")
            .price(new BigDecimal(500))
            .seatClass(SeatClass.SUITE)
            .numberOfPersons(3)
            .ticketState(TicketState.CANCELLED)
            .isCanceled(true)
            .build();

    @Test
    void mapFromNotCanceledCase() {
        var result = mapper.mapFrom(TICKET_NOT_CANCELED);

        assertEquals(TICKET_READ_DTO_MAPPED_NOT_CANCELED, result);
    }
    @Test
    void mapFromCanceledCase() {
        var result = mapper.mapFrom(TICKET_CANCELED);

        assertEquals(TICKET_READ_DTO_MAPPED_CANCELED, result);
    }
}