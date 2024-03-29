package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.SeatReadDto;
import com.didenko.starcruises.entity.Seat;
import com.didenko.starcruises.entity.SeatClass;
import com.didenko.starcruises.entity.SeatVacancy;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeatReadDtoMapperTest {

    private final SeatReadDtoMapper mapper = new SeatReadDtoMapper();

    private static final Seat SEAT_1 = Seat.builder()
            .seatGroup(1)
            .number(1)
            .numberOfPersons(3)
            .price(new BigDecimal(500))
            .vacancy(SeatVacancy.VACANT)
            .seatClass(SeatClass.SUITE)
            .build();
    private static final Seat SEAT_2 = Seat.builder()
            .seatGroup(1)
            .number(2)
            .numberOfPersons(3)
            .price(new BigDecimal(500))
            .vacancy(SeatVacancy.BOOKED)
            .seatClass(SeatClass.SUITE)
            .build();
    private static final Seat SEAT_3 = Seat.builder()
            .seatGroup(1)
            .number(3)
            .numberOfPersons(3)
            .price(new BigDecimal(500))
            .vacancy(SeatVacancy.VACANT)
            .seatClass(SeatClass.SUITE)
            .build();
    private static final Seat SEAT_4 = Seat.builder()
            .seatGroup(2)
            .number(4)
            .numberOfPersons(2)
            .price(new BigDecimal(200))
            .vacancy(SeatVacancy.VACANT)
            .seatClass(SeatClass.INTERIOR)
            .build();
    private static final Seat SEAT_5 = Seat.builder()
            .seatGroup(2)
            .number(5)
            .numberOfPersons(2)
            .price(new BigDecimal(200))
            .vacancy(SeatVacancy.BOOKED)
            .seatClass(SeatClass.INTERIOR)
            .build();

    private static final SeatReadDto MAPPED_SEAT_DTO_1 = SeatReadDto.builder()
            .seatGroup(1)
            .seatClass(SeatClass.SUITE)
            .freeSeatsAvailable(2L)
            .price(new BigDecimal(500))
            .numberOfPersons(3)
            .build();
    private static final SeatReadDto MAPPED_SEAT_DTO_2 = SeatReadDto.builder()
            .seatGroup(2)
            .seatClass(SeatClass.INTERIOR)
            .freeSeatsAvailable(1L)
            .price(new BigDecimal(200))
            .numberOfPersons(2)
            .build();
    @Test
    void mapFrom() {
        var expectedResult = List.of(MAPPED_SEAT_DTO_1, MAPPED_SEAT_DTO_2);
        var result = mapper.mapFrom(List.of(SEAT_1, SEAT_2, SEAT_3,SEAT_4, SEAT_5));

        assertEquals(expectedResult, result);

    }
}