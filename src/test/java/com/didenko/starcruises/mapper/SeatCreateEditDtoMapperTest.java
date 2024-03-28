package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.SeatCreateEditDto;
import com.didenko.starcruises.entity.Seat;
import com.didenko.starcruises.entity.SeatClass;
import com.didenko.starcruises.entity.SeatVacancy;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeatCreateEditDtoMapperTest {

    private static final Seat SEAT_ENTITY_1 = Seat.builder()
            .id(1L)
            .seatGroup(1)
            .number(1)
            .numberOfPersons(2)
            .price(new BigDecimal(1000))
            .vacancy(SeatVacancy.VACANT)
            .seatClass(SeatClass.INTERIOR)
            .build();
    private static final Seat SEAT_ENTITY_2 = Seat.builder()
            .id(2L)
            .seatGroup(1)
            .number(2)
            .numberOfPersons(1)
            .price(new BigDecimal(1000))
            .vacancy(SeatVacancy.BOOKED)
            .seatClass(SeatClass.INTERIOR)
            .build();
    private static final Seat SEAT_ENTITY_3 = Seat.builder()
            .id(3L)
            .seatGroup(2)
            .number(3)
            .numberOfPersons(3)
            .price(new BigDecimal(1500))
            .vacancy(SeatVacancy.VACANT)
            .seatClass(SeatClass.INTERIOR)
            .build();
    private static final Seat SEAT_ENTITY_4 = Seat.builder()
            .id(4L)
            .seatGroup(2)
            .number(4)
            .numberOfPersons(3)
            .price(new BigDecimal(1500))
            .vacancy(SeatVacancy.VACANT)
            .seatClass(SeatClass.INTERIOR)
            .build();
    private static final Seat SEAT_ENTITY_5 = Seat.builder()
            .id(5L)
            .seatGroup(2)
            .number(5)
            .numberOfPersons(3)
            .price(new BigDecimal(1500))
            .vacancy(SeatVacancy.VACANT)
            .seatClass(SeatClass.INTERIOR)
            .build();

    private static final SeatCreateEditDto MAPPED_SEAT_DTO_GROUP_1 = SeatCreateEditDto.builder()
            .seatGroup(1)
            .seatClass(SeatClass.INTERIOR)
            .seatPrice("1000")
            .firstSeatNumber(1)
            .lastSeatNumber(2)
            .numberOfPersons(2)
            .build();
  private static final SeatCreateEditDto MAPPED_SEAT_DTO_GROUP_2 = SeatCreateEditDto.builder()
          .seatGroup(2)
          .seatClass(SeatClass.INTERIOR)
          .seatPrice("1500")
          .firstSeatNumber(3)
          .lastSeatNumber(5)
          .numberOfPersons(3)
          .build();

  private static final SeatCreateEditDto SEAT_DTO = SeatCreateEditDto.builder()
          .seatGroup(1)
          .seatClass(SeatClass.SUITE)
          .seatPrice("3000")
          .firstSeatNumber(5)
          .lastSeatNumber(7)
          .numberOfPersons(5)
          .build();

  private static final Seat MAPPED_SEAT_ENTITY_5 = Seat.builder()
          .seatGroup(1)
          .number(5)
          .numberOfPersons(5)
          .price(new BigDecimal(3000))
          .vacancy(SeatVacancy.VACANT)
          .seatClass(SeatClass.SUITE)
          .build();
    private static final Seat MAPPED_SEAT_ENTITY_6 = Seat.builder()
            .seatGroup(1)
            .number(6)
            .numberOfPersons(5)
            .price(new BigDecimal(3000))
            .vacancy(SeatVacancy.VACANT)
            .seatClass(SeatClass.SUITE)
            .build();
    private static final Seat MAPPED_SEAT_ENTITY_7 = Seat.builder()
            .seatGroup(1)
            .number(7)
            .numberOfPersons(5)
            .price(new BigDecimal(3000))
            .vacancy(SeatVacancy.VACANT)
            .seatClass(SeatClass.SUITE)
            .build();

    private final SeatCreateEditDtoMapper mapper = new SeatCreateEditDtoMapper();
    @Test
    void mapFromEntity() {

        List<Seat> seatList = List.of(SEAT_ENTITY_1, SEAT_ENTITY_2, SEAT_ENTITY_3, SEAT_ENTITY_4, SEAT_ENTITY_5);

        assertEquals(List.of(MAPPED_SEAT_DTO_GROUP_1, MAPPED_SEAT_DTO_GROUP_2),
                mapper.mapFrom(seatList, SeatClass.INTERIOR));
    }

    @Test
    void mapFromDto() {
        List<Seat> expectedSeats = List.of(MAPPED_SEAT_ENTITY_5, MAPPED_SEAT_ENTITY_6, MAPPED_SEAT_ENTITY_7);
        List<Seat> mappingResult = List.of(
                mapper.mapFrom(SEAT_DTO, 5),
                mapper.mapFrom(SEAT_DTO, 6),
                mapper.mapFrom(SEAT_DTO, 7)
        );

        assertEquals(expectedSeats, mappingResult);
    }
}