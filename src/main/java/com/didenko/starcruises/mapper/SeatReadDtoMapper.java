package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.SeatReadDto;
import com.didenko.starcruises.entity.Seat;
import com.didenko.starcruises.entity.SeatVacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class SeatReadDtoMapper {
    public List<SeatReadDto> mapFrom(List<Seat> seats) {

        Map<Integer, List<Seat>> groupedSeats = seats.stream().collect(Collectors.groupingBy(Seat::getSeatGroup));

        List<SeatReadDto> seatReadDtos = new ArrayList<>();

        for (Integer group : groupedSeats.keySet()) {
            List<Seat> currentGroup = groupedSeats.get(group);
            Seat seatSample = currentGroup.get(0);

            seatReadDtos.add(SeatReadDto.builder()
                    .seatClass(seatSample.getSeatClass())
                    .price(seatSample.getPrice())
                    .numberOfPersons(seatSample.getNumberOfPersons())
                    .seatGroup(seatSample.getSeatGroup())
                    .freeSeatsAvailable(currentGroup.stream()
                            .filter(seat -> seat.getVacancy().equals(SeatVacancy.VACANT)).count())
                    .build());
        }

        return seatReadDtos;
    }

}