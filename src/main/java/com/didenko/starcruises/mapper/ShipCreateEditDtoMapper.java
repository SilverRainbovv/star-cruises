package com.didenko.starcruises.mapper;

import com.didenko.starcruises.dto.SeatCreateEditDto;
import com.didenko.starcruises.dto.ShipCreateEditDto;
import com.didenko.starcruises.entity.Seat;
import com.didenko.starcruises.entity.SeatClass;
import com.didenko.starcruises.entity.Ship;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ShipCreateEditDtoMapper implements Mapper<ShipCreateEditDto, Ship> {

    private final SeatCreateEditDtoMapper seatCreateEditDtoMapper;

    @Override
    public Ship mapFrom(ShipCreateEditDto shipDto) {
        Ship ship = Ship.builder()
                .name(shipDto.getName())
                .build();

        List<SeatCreateEditDto> seatDtos = shipDto.getSeats();

        seatDtos.forEach(seatDto -> createSeatsGroup(seatDto, ship));
        return ship;
    }

    public ShipCreateEditDto mapFrom(Ship ship){
        Map<SeatClass, List<Seat>> seats = ship.getSeats().stream()
                .collect(Collectors.groupingBy(Seat::getSeatClass));

        List<SeatCreateEditDto> seatCreateDtoList = new ArrayList<>();

        seats.forEach((seatClass, seat) -> {
            seatCreateDtoList.addAll(seatCreateEditDtoMapper.mapFrom(seat, seatClass));
        });

        return ShipCreateEditDto.builder()
                .name(ship.getName())
                .previousName(ship.getName())
                .seats(seatCreateDtoList)
                .build();
    }


    private void createSeatsGroup(SeatCreateEditDto seatDto, Ship ship){
        for (int i = seatDto.getFirstSeatNumber(); i <= seatDto.getLastSeatNumber(); i++){
            Seat seat = seatCreateEditDtoMapper.mapFrom(seatDto, i);
            seat.setShip(ship);
        }
    }

}
