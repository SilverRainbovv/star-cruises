package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.SeatCreateDto;
import com.didenko.starcruises.dto.ShipCreateEditDto;
import com.didenko.starcruises.entity.Seat;
import com.didenko.starcruises.entity.Ship;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ShipCreateEditMapper implements Mapper<ShipCreateEditDto, Ship> {

    private final SeatCreateEditMapper seatCreateEditMapper;

    @Override
    public Ship mapFrom(ShipCreateEditDto shipDto) {
        Ship ship = Ship.builder()
                .name(shipDto.getName())
                .build();

        List<SeatCreateDto> seatDtos = shipDto.getSeats();

        seatDtos.forEach(seatDto -> createSeatsGroup(seatDto, ship));
        return ship;
    }

    private void createSeatsGroup(SeatCreateDto seatDto, Ship ship){
        for (int i = seatDto.getFirstSeatNumber(); i <= seatDto.getLastSeatNumber(); i++){
            Seat seat = seatCreateEditMapper.mapFrom(seatDto, i);
            seat.setShip(ship);
        }
    }

}
