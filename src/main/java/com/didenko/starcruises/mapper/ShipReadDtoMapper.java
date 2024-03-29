package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.ShipReadDto;
import com.didenko.starcruises.entity.Seat;
import com.didenko.starcruises.entity.Ship;
import org.springframework.stereotype.Component;

@Component
public class ShipReadDtoMapper implements Mapper<Ship, ShipReadDto> {
    @Override
    public ShipReadDto mapFrom(Ship object) {
        return ShipReadDto.builder()
                .id(object.getId())
                .name(object.getName())
//                .passengerCapacity(object.getSeats().size())
                .passengerCapacity(object.getSeats().stream().map(Seat::getNumberOfPersons)
                        .reduce(0, Integer::sum))
                .scheduledCruises(object.getCruises().size())
                .image(object.getImage())
                .build();
    }
}
