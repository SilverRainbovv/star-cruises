package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.SeatCreateEditDto;
import com.didenko.starcruises.entity.Seat;
import com.didenko.starcruises.entity.SeatClass;
import com.didenko.starcruises.entity.Vacancy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class SeatCreateEditDtoMapper {
    public Seat mapFrom(SeatCreateEditDto seatDto, int seatNumber) {
        return  Seat.builder()
                .seatGroup(seatDto.getSeatGroup())
                .number(seatNumber)
                .price(new BigDecimal(seatDto.getSeatPrice()))
                .vacancy(Vacancy.VACANT)
                .seatClass(seatDto.getSeatClass())
                .build();
    }

    public List<SeatCreateEditDto> mapFrom(List<Seat> seats, SeatClass seatClass){

        Map<Integer, List<Seat>> groupedBySeatGroup = seats.stream()
                .collect(Collectors.groupingBy(Seat::getSeatGroup));

        List<SeatCreateEditDto> createEditDtos = new ArrayList<>();

        groupedBySeatGroup.forEach((group, seatList) -> {
            createEditDtos.add(
            SeatCreateEditDto.builder()
                    .seatClass(seatClass)
                    .seatGroup(group)
                    .seatPrice(seatList.get(0).getPrice().toString())
                    .firstSeatNumber(seatList.stream().mapToInt(Seat::getNumber).min().getAsInt())
                    .lastSeatNumber(seatList.stream().mapToInt(Seat::getNumber).max().getAsInt())
                    .build());
        });

        return createEditDtos;
    }

}
