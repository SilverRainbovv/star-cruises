package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.SeatCreateEditDto;
import com.didenko.starcruises.dto.ShipCreateEditDto;
import com.didenko.starcruises.entity.Seat;
import com.didenko.starcruises.entity.SeatClass;
import com.didenko.starcruises.entity.SeatVacancy;
import com.didenko.starcruises.entity.Ship;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ShipCreateEditDtoMapperTest {

    @Mock
    private SeatCreateEditDtoMapper seatMapper;
    @InjectMocks
    private ShipCreateEditDtoMapper mapper;

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
    private static final Ship SHIP = Ship.builder()
            .id(1L)
            .name("ship")
            .image("image_url")
            .seats(List.of(SEAT_ENTITY_1, SEAT_ENTITY_2, SEAT_ENTITY_3, SEAT_ENTITY_4, SEAT_ENTITY_5))
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
    private static final ShipCreateEditDto MAPPED_SHIP_DTO = ShipCreateEditDto.builder()
            .id(1L)
            .name("ship")
            .previousName("ship")
            .seats(List.of(MAPPED_SEAT_DTO_GROUP_1, MAPPED_SEAT_DTO_GROUP_2))
            .build();
    @Test
    void mapFromEntity() {
        Mockito.doReturn(List.of(MAPPED_SEAT_DTO_GROUP_1, MAPPED_SEAT_DTO_GROUP_2)).when(seatMapper).mapFrom(SHIP.getSeats(), SeatClass.INTERIOR);

        assertEquals(MAPPED_SHIP_DTO, mapper.mapFrom(SHIP));
    }

    @Test
    void mapFromDto() {
    }
}