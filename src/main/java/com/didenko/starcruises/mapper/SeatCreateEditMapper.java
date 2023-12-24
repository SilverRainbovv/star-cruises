package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.SeatCreateDto;
import com.didenko.starcruises.entity.Seat;
import com.didenko.starcruises.entity.Vacancy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SeatCreateEditMapper {
    public Seat mapFrom(SeatCreateDto seatDto, int seatNumber) {
        return  Seat.builder()
                .number(seatNumber)
                .price(new BigDecimal(seatDto.getSeatPrice()))
                .vacancy(Vacancy.VACANT)
                .seatClass(seatDto.getSeatClass())
                .build();
    }
}
