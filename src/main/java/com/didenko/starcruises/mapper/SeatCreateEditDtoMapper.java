package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.SeatCreateEditDto;
import com.didenko.starcruises.entity.Seat;
import com.didenko.starcruises.entity.SeatClass;
import com.didenko.starcruises.entity.SeatVacancy;
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
                .vacancy(SeatVacancy.VACANT)
                .seatClass(seatDto.getSeatClass())
                .numberOfPersons(seatDto.getNumberOfPersons())
                .build();
    }

    /**
     * receives list of Seat and seatClass from ShipCreateEditDtoMapper
     * groups seats by their seat group and maps to SeatCreateEditDto type
     * @param seats list os seats of specified seatclass
     * @param seatClass specified in ShipCreateEditDtoMapper
     * @return List< SeatCreateEditDto >
     */
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
                    .numberOfPersons(seatList.get(0).getNumberOfPersons())
                    .build());
        });

        return createEditDtos;
    }

}
